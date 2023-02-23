package com.longbig.multifunction.utils;

import java.nio.charset.Charset;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description
 * @create 2023-02-21 12:46
 **/
public class SystemProperty {

    public static Charset CHARSET = Charset.forName("utf-8");
    public static final String token = "vBw5w";

    public static String getProp(String key) {
        return System.getProperty(key);
    }

    public static String getProp(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }
}
