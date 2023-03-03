package com.longbig.multifunction.job;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.longbig.multifunction.service.WeChatService;
import com.longbig.multifunction.utils.OkHttpUtils;
import java.util.Objects;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yuyunlong
 * @date 2022/9/4 4:34 下午
 * @description
 */
@Slf4j
@Component
public class JuejinJob {

    @Value("${juejin.Cookie}")
    private String juejinCookie;
    @Value("${draw.to.user}")
    private String drawToUser;

    @Resource private WeChatService weChatService;

    /**
     * 掘金自动签到
     *
     * @return
     */
    @Scheduled(cron = "0 0 9 1/1 * ?")
    public String juejinSign() throws Exception {
        log.info("掘金自动签到开始");
        Integer beforePoint = getCurPoint();
        Map<String, String> header = Maps.newHashMap();
        String url = "https://api.juejin.cn/growth_api/v1/check_in";
        RequestBody requestBody = new FormBody.Builder().build();
        String response = OkHttpUtils.post(url, juejinCookie, requestBody, header);
        Integer afterPoint = getCurPoint();
        weChatService.sendMsg("签到结果:" + beforePoint + " -> " + afterPoint, drawToUser);
        return response;
    }

    /**
     * 掘金自动抽奖
     *
     * @return
     */
    @Scheduled(cron = "0 0 9,11 * * ?")
    public String juejinDraw() throws Exception {
        log.info("掘金自动抽奖开始");
        Integer beforePoint = getCurPoint();
        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/growth_api/v1/lottery/draw";
        RequestBody requestBody = new FormBody.Builder().build();
        String response = OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
        JSONObject jb = JSON.parseObject(response);
        Object data = jb.get("data");
        String lottery_name = (String) JSON.parseObject(JSON.toJSONString(data)).get("lottery_name");
        Integer afterPoint = getCurPoint();
        weChatService.sendMsg(DateUtil.now() + "抽奖奖品:" + lottery_name
            + "\br抽奖结果:" + beforePoint + " -> " + afterPoint, drawToUser);
        return response;
    }

    @Scheduled(cron = "0 02 9 1/1 * ?")
    public void dipLucky() throws Exception {
        log.info("粘喜气");
        String history = this.lotteryHistory();
        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/growth_api/v1/lottery_lucky/dip_lucky";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, "{\"lottery_history_id\":\"" + history + "\"}");

        OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
    }
    public String lotteryHistory() throws Exception {
        log.info("查可粘列表");
        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/growth_api/v1/lottery_history/global_big";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, "{\"page_no\":1,\"page_size\":5}");

        String response = OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
        JSONObject jsonObject = JSON.parseObject(response);
        Object data = jsonObject.get("data");
        JSONArray lotteries = JSON.parseObject(JSON.toJSONString(data)).getJSONArray("lotteries");

        String s = lotteries.get(0).toString();
        JSONObject jb = JSON.parseObject(s);
        return jb.get("history_id").toString();
    }


    @Scheduled(cron = "0 01 9 1/1 * ?")
    public void collectBugs() throws Exception {
        log.info("掘金bug收集");
        JSONArray bugList = this.getBugList();
        while (Objects.nonNull(bugList) && bugList.size() > 0) {
            for (Object bug : bugList) {
                String bugStr = JSON.toJSONString(bug);
                log.info("开始处理bug: {}", bugStr);
                collect(bugStr);
            }
            bugList = this.getBugList();
        }
    }

    public void collect(String body) throws Exception {

        log.info("开始获取bug");
        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/user_api/v1/bugfix/collect";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, body);
        OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
    }
    public JSONArray getBugList() throws Exception {

        log.info("开始获取bug列表");
        Map<String, String> header = Maps.newHashMap();
        String drawUrl = "https://api.juejin.cn/user_api/v1/bugfix/not_collect";
        RequestBody requestBody = new FormBody.Builder().build();
        String response = OkHttpUtils.post(drawUrl, juejinCookie, requestBody, header);
        JSONObject jsonObject = JSON.parseObject(response);
        JSONArray data = jsonObject.getJSONArray("data");
        log.info("获取到的bug列表为: {}", data);
        return data;
    }

    public Integer getCurPoint() throws Exception {
        log.info("开始获取当前积分数量");
        Map<String, String> header = Maps.newHashMap();
        String url = "https://api.juejin.cn/growth_api/v1/get_cur_point";
        String response = OkHttpUtils.get(url, juejinCookie, header);
        JSONObject jsonObject = JSON.parseObject(response);
        return (Integer) jsonObject.get("data");
    }
}
