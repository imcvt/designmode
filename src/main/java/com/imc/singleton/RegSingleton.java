package com.imc.singleton;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luoly
 * @date 2018/11/28 16:51
 * @description 登记式单例类
 */
public class RegSingleton {

    private static Map regMap = new HashMap();

    static {
        RegSingleton regSingleton = new RegSingleton();
        regMap.put(regSingleton.getClass().getName(), regSingleton);
    }

    /**
     * 保护的构造方法
     */
    protected RegSingleton(){}

    public static RegSingleton getInstance(String name) {
        if(null == name) {
            name = "com.imc.singleton.RegSingleton";
        }else if(null == regMap.get(name)) {
            try {
                //此处通过构造器方法 可以产生子类实例 子类的构造器可以是私有的，不允许其他地方创建实例
                Constructor constructor = Class.forName(name).getDeclaredConstructor();
                constructor.setAccessible(true);
                regMap.put(name, constructor.newInstance());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return (RegSingleton) regMap.get(name);
    }
}
