package com.longbig.multifunction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description
 * @create 2023-06-27 16:45
 **/
@Configuration
public class BeanConfiguration {
    /**
     * 用户 apiKey，需用户填写，在 https://www.bitget.com 中创建apikey
     */
    String apiKey = "bg_f18279194b515ecfb7e12b6652ddefac";
    /**
     * 用户 secretKey，需用户填写，在 https://www.bitget.com/user  api 中获取
     */
    String secretKey = "efbc5ed2b1ee05e34637a3b6329cba71a253d85c339a6458f65b0cb7a79590b0";
    /**
     * 口令，需用户填写，在 https://www.bitget.com/user  api 中获取（创建时由用户设定）
     */
    String passphrase = "dagezhenshuai0713";
    /**
     * open api 根路径
     */
    String baseUrl = "https://api.bitget.com/api/swap/v3/";

//    @Bean
//    public BitgetRestClient getBigGetClient() {
//        ClientParameter parameter = ClientParameter.builder()
//            .apiKey(apiKey)
//            .secretKey(secretKey)
//            .passphrase(passphrase)
//            .baseUrl(baseUrl)
//            .build();
//
//        return BitgetRestClient.builder()
//            .configuration(parameter)
//            .build();
//    }

}
