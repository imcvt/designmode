package com.imc.singleton;

/**
 * @author luoly
 * @date 2018/11/28 17:05
 * @description
 */
public class RegSingletonChild extends RegSingleton{

    //私有构造器 只允许特定地方创建实例
    private RegSingletonChild() {}

    public static RegSingletonChild getInstance() {
        return (RegSingletonChild) RegSingleton.getInstance("com.imc.singleton.RegSingletonChild");
    }
}
