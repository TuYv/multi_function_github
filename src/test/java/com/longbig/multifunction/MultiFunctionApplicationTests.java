package com.longbig.multifunction;

import com.alibaba.fastjson.JSON;
import com.longbig.multifunction.job.JuejinJob;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiFunctionApplicationTests {
    @Resource
    JuejinJob juejinJob;
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

}
