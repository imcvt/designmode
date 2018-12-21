package com.imc.singleton.multilingual;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author luoly
 * @date 2018/11/30 17:51
 * @description Locale国际化测试，通过Resource Bundle 获取文件前缀及_符号队隔开的本地化
 */
public class LingualResourceTest {
    public static void main(String[] args) {
        LingualResource ling = LingualResource.getInstance("en", "US");
        String usDollar = ling.getLocaleString("USD");
        System.out.println("USD=" + usDollar);

        LingualResource lingZh = LingualResource.getInstance("zh", "CH");
        String usDollarZh = lingZh.getLocaleString("USD");
        System.out.println("USD=" + usDollarZh);


        /*************** 多语言测试 **************/
        Locale locale1 = new Locale("zh", "CN");
        System.out.println(locale1.getCountry());
        System.out.println(locale1.getDisplayCountry());
        System.out.println(locale1.getLanguage());
        System.out.println(locale1.getDisplayLanguage());
        Locale locale2 = new Locale("en", "US");
        System.out.println(locale1.getDisplayCountry(locale2));
        System.out.println(locale1.getDisplayLanguage(locale2));

        ResourceBundle resourceBundle = ResourceBundle.getBundle("dictionary", new Locale("", ""));
        System.out.println("locale3-->"+resourceBundle.getString("USD"));

        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("dictionary", new Locale("ar", ""));
        System.out.println("locale4-->"+resourceBundle1.getString("USD"));

        ResourceBundle resourceBundle5 = ResourceBundle.getBundle("dictionary", new Locale("pl", "BL"));
        System.out.println("locale5-->"+resourceBundle5.getString("USD"));
    }
}
