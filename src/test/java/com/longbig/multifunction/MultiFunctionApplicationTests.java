package com.longbig.multifunction;

import com.alibaba.fastjson.JSON;
import com.binance.connector.client.SpotClient;
import com.binance.connector.client.impl.SpotClientImpl;
import com.google.common.collect.Maps;
import com.longbig.multifunction.job.JuHeJob;
import com.longbig.multifunction.job.JuejinJob;
import com.longbig.multifunction.service.ChatGptService;
import com.longbig.multifunction.service.fairy.func.Arena;
import com.longbig.multifunction.service.fairy.obj.Player;
import com.longbig.multifunction.up.SpecialistSubject;
import com.longbig.multifunction.up.SubjectMapping;
import com.longbig.multifunction.up.mapper.SpecialistSubjectMapper;
import com.longbig.multifunction.up.mapper.SubjectMappingMapper;
import com.longbig.multifunction.utils.OkHttpUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiFunctionApplicationTests {

    @Value("${juejin.Cookie}")
    private String juejinCookie;
    @Value("${weather.forecast.key}")
    private String weatherForecastKey;
    @Resource JuejinJob juejinJob;
    @Resource JuHeJob juHeJob;
    @Resource SpecialistSubjectMapper specialistSubjectMapper;
    @Resource SubjectMappingMapper subjectMappingMapper;

    @Test
    public void weatherTest() throws Exception {
        List<SubjectMapping> subjectMappingList = subjectMappingMapper.queryAll();
        Map<String, String> sMap = subjectMappingList.stream().collect(Collectors.toMap(SubjectMapping::getSpecialistName, SubjectMapping::getSpecialistCode, (o1, o2) -> o1));
        List<SpecialistSubject> specialistSubjectList = specialistSubjectMapper.queryAll();
        List<SpecialistSubject> empytList = new ArrayList<>();
        for (SpecialistSubject sSubject : specialistSubjectList) {
            if (sMap.containsKey(sSubject.getClassName())) {
                sSubject.setClassCode(sMap.get(sSubject.getClassName()));
                specialistSubjectMapper.updateByPrimaryKeySelective(sSubject);
            } else {
                empytList.add(sSubject);
            }
        }
        System.out.println(JSON.toJSONString(empytList));

    }
    @Resource ChatGptService chatGptService;
//    @Resource BitgetRestClient bitgetClient;
    @Resource Arena arena;
    @Test
    public void juejinSign() throws Exception {
        System.out.println(JSON.toJSONString(juejinJob.juejinSign()));
    }
    @Test
    public void juejinDraw() throws Exception {
        System.out.println(JSON.toJSONString(juejinJob.juejinDraw()));
    }
    @Test
    public void collectBugs() throws Exception {
        juejinJob.collectBugs();
        //System.out.println(JSON.toJSONString(juejinJob.collectBugs()));
    }
    @Test
    public void getBugList() throws Exception {
        juejinJob.getBugList();
        //System.out.println(JSON.toJSONString(juejinJob.collectBugs()));
    }
    @Test
    public void dipLucky() throws Exception {
        juejinJob.dipLucky();
    }
    @Test
    public void getCurPoint() throws Exception {

        Map<String, String> header = Maps.newHashMap();
        String url = "https://api.juejin.cn/growth_api/v1/get_cur_point";
        String response = OkHttpUtils.get(url, juejinCookie, header);
    }
    @Test
    public void famousQuotes() throws Exception {
        juHeJob.famousQuotes("TuYv");
    }

    @Test
    public void fixBug() throws Exception {

        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/user_api/v1/bugfix/competition";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = new FormBody.Builder().build();
        String result = OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
        String competitionId = JSON.parseObject(JSON.toJSONString(JSON.parseObject(result).get("data"))).getString("competition_id");

        Integer bugCount = getBugCount(competitionId);
    }

    public Integer getBugCount(String competitionId) throws Exception {
        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/user_api/v1/bugfix/user";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, "{\"competition_id\": \""+ competitionId +"\"}");
        String result = OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
        Integer ownBug = JSON.parseObject(JSON.toJSONString(JSON.parseObject(result).get("data"))).getInteger("user_own_bug");
        System.out.println(ownBug);
        return ownBug;
    }

    @Test
    public void gpt() throws Exception {
        chatGptService.openAiComplete("你好");
    }

    @Test
    public void timeParse() {
        String time = "1687794256291";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(time)));
        System.out.println(sd);
    }

//    @Test
//    public void bitgit() throws IOException {
//
//        //ResponseResult info = bitgetClient.mix().bitget().account().getAccount("BTCUSDT_UMCBL", "USDT");
//        ResponseResult info = bitgetClient.mix().bitget().trace().traderList("", "", "", "composite", "desc", "zh-CN", "", "");
//        List<TraderDTO> traderList = JSON.parseArray(JSON.toJSONString(info.getData()), TraderDTO.class);
////        traderList.stream().limit(10).forEach(trader -> {
////            System.out.println("交易员姓名：" + trader.getTraderNickName() + ", 简介：" + trader.getProfile() + "，可交易:" + trader.getTradingPairsAvailable());
////        });
//        traderList.stream().limit(20)
//            .forEach(trader -> {
//                try {
//                    ResponseResult result = bitgetClient.mix().bitget().trace().currentList(trader.getTraderUid(), "", "", "");
//                    List<TraderCurrentDTO> currentTradeList = JSON.parseArray(JSON.toJSONString(result.getData()), TraderCurrentDTO.class);
//                    if (CollectionUtils.isEmpty(currentTradeList)) {
//                        System.out.println("交易员" + trader.getTraderNickName() + " ETH " + "无持仓");
//                    } else {
//                        currentTradeList.stream().filter(trade -> Objects.equals(trade.getSymbol(), "ETHUSDT"))
//                            .forEach(trade -> {
//                                String side = Objects.equals(trade.getHoldSide(), "long") ? "多" : "空";
//                                side = side + trade.getLeverage();
//                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//                                System.out.println("交易员" + trader.getTraderNickName() + " ETH " + side + ", 开仓均价：" + trade.getOpenPrice() + ", 开仓时间:" + sdf.format(new Date(Long.parseLong(trade.getOpenTime()))));
//                            });
//                    }
//
//                }  catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//    }
////    @Test
////    public void bitget2() throws IOException {
////        ResponseResult result = bitgetClient.mix().bitget().market().contracts("umcbl");
////        System.out.println(JSON.toJSONString(result.getData()));
////    }
////    @Test
////    public void bitget3() throws IOException {
////        ResponseResult result = bitgetClient.mix().bitget().market().ticker("ETHUSDT_UMCBL");
////        System.out.println(JSON.toJSONString(result.getData()));
////    }
    @Test
    public void testFairy() {
        List<Player> playerList = arena.initPlayer();
        playerList.forEach(Player::print);
    }
    @Test
    public void testVS() {
    }

    @Test
    public void fairyNew() {
        String s = "lconzuxbojzuxzitsaxxxyzo";
        arena.vsFairy(s);
    }

    @Test
    public void binanceTest() {
        SpotClient client = new SpotClientImpl("4Pcogv2phllE2RaP93YLPffQQyl8Rf4EgkK52Orf0T6Z5akQvyf5g3FF2Kof1zMP", "WHQLi4nXZqDunaChDz7DKP1IANytwSeYPBdEYmm1zf7NSvac1YRlXAdr17SBSAP4");

        Map<String,Object> parameters = new LinkedHashMap<String,Object>();
//        parameters.put("symbol","BTCUSDT");
//        parameters.put("side", "SELL");
//        parameters.put("type", "LIMIT");
//        parameters.put("timeInForce", "GTC");
//        parameters.put("quantity", 0.01);
//        parameters.put("price", 9500);
        parameters.put("timestamp", new Date().getTime());

        String account = client.createTrade().account(parameters);
        System.out.println(account);
    }
}
