package com.longbig.multifunction;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.longbig.multifunction.job.JuHeJob;
import com.longbig.multifunction.job.JuejinJob;
import com.longbig.multifunction.utils.OkHttpUtils;
import java.util.Map;
import javax.annotation.Resource;
import okhttp3.FormBody;
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
    public void weatherTest() throws Exception {
        juHeJob.dailyWeather(null);
    }


}
