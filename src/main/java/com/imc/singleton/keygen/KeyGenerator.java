package com.imc.singleton.keygen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoly
 * @date 2018/12/1 14:03
 * @description 主键生成器
 */
public class KeyGenerator {

    private static KeyGenerator keyGenerator = new KeyGenerator();

    Integer next = 1000;

    private KeyInfo keyInfo;

    /**
     * 引进一个KeyInfo的聚集 存储不同的主键
     */
    private static Map<String, KeyInfo> keyInfosMap = new HashMap();

    /**
     * 私有构造方法 不允许外界创建 把keyIfo放在单例类的初始化方法中，keyInfo对象在当前对象中也是唯一的
     */
    private KeyGenerator() {

    }

    /**
     * 获取唯一实例
     * @return
     */
    public static KeyGenerator getInstance() {
        return keyGenerator;
    }

    public synchronized Integer getNext(String keyName) {
        KeyInfo keyInfo;
        if(keyInfosMap.containsKey(keyName)) {
            keyInfo = keyInfosMap.get(keyName);
        }else {
            keyInfo = new KeyInfo(20, keyName);
            keyInfosMap.put(keyName, keyInfo);
        }
        return  keyInfo.getNext();
    }

}
