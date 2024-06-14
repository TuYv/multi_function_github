package com.longbig.multifunction.job;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.longbig.multifunction.service.WeChatService;
import com.longbig.multifunction.utils.OkHttpUtils;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description
 * @create 2023-03-01 13:37
 **/
@Slf4j
@Service
public class JuHeJob {
    @Value("${weather.forecast.key}")
    private String weatherForecastKey;
    @Value("${famous.quotes.key}")
    private String famousQuotesKey;

    @Resource
    private WeChatService weChatService;
    public void weatherForecast(String toUser) throws Exception{
        Map<String, String> header = Maps.newHashMap();
        String url = "http://apis.juhe.cn/simpleWeather/query?city=上海&key=" + weatherForecastKey;
        String response = OkHttpUtils.get(url, "", header);
        Object result = JSON.parseObject(response).get("result");
        JSONObject realtime = JSON.parseObject(JSON.toJSONString(JSON.parseObject(JSON.toJSONString(result)).get("realtime")));
        String msg = "当前上海天气为" + realtime.get("temperature") + "度,湿度:" + realtime.get("humidity") + ",空气质量:" + realtime.get("aqi") + "," + realtime.get("power") + realtime.get("direct");
        log.info(msg);
        weChatService.sendMsg(msg, toUser);
    }
    @Scheduled(cron = "0 30 8 * * ?")
    public void dailyWeather() throws Exception{
        this.weatherForecast("@all");
    }
    @Scheduled(cron = "0 30 9 * * ?")
    public void dailyQuotes() throws Exception{
        this.famousQuotes("@all");
    }

    public void famousQuotes(String toUser) throws Exception{
        int typeId = RandomUtil.randomInt(1,46);
        Map<String, String> header = Maps.newHashMap();
        String url = "http://apis.juhe.cn/fapigx/mingyan/query?num=1&typeid=" + typeId +"&key=" + famousQuotesKey;
        String response = OkHttpUtils.get(url, "", header);
        Object result = JSON.parseObject(response).get("result");
        JSONObject quote = JSON.parseObject(JSON.toJSONString(JSON.parseArray(JSON.toJSONString(JSON.parseObject(JSON.toJSONString(result)).get("list"))).get(0)));
        String msg = quote.getString("content") + "\n\n\t\t" + quote.getString("author");
        log.info(msg);
        weChatService.sendMsg(msg, toUser);
    }

}
