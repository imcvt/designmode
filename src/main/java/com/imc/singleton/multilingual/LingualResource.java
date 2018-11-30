package com.imc.singleton.multilingual;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author luoly
 * @date 2018/11/30 17:19
 * @description
 */
public class LingualResource {
    private static String language = "en";
    private static String region = "US";
    private static String localeCode = "en_US";
    private static final String FILE_NAME = "res";
    private static HashMap instances = new HashMap(19);
    private Locale locale = null;
    private ResourceBundle resourceBundle = null;
    private LingualResource lingualResource;

    /**
     * 私有构造方法
     * @param language
     * @param region
     */
    private LingualResource(String language, String region) {
        this.localeCode = language;
        this.region = region;
        localeCode = makeLocaleCode(language, region);
        locale = new Locale(language, region);
        resourceBundle = ResourceBundle.getBundle(FILE_NAME, locale);
        instances.put(makeLocaleCode(language, region), resourceBundle);
    }

    /**
     * 私有构造方法
     */
    private LingualResource() {

    }

    /**
     * 工厂方法 获取一个具有指定的内部状态的实例
     * @return
     */
    public synchronized static LingualResource getInstance(String language, String region) {
        if(null != instances.get(makeLocaleCode(language, region))) {
            return (LingualResource)instances.get(makeLocaleCode(language, region));
        }else {
            return new LingualResource(language, region);
        }
    }

    public String getLocaleString(String code) {
        return resourceBundle.getString(code);
    }

    private static String  makeLocaleCode(String language, String region) {
        return language + "_" + region;
    }


}
