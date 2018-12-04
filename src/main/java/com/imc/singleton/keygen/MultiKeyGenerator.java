package com.imc.singleton.keygen;

import java.util.HashMap;

/**
 * @author luoly
 * @date 2018/12/3 17:48
 * @description
 */
public class MultiKeyGenerator {

    private static final Integer POOL_SIZE = 20;

    private static HashMap multiKeyGenerators = new HashMap(10);

    private KeyInfo keyInfo;

    /**
     * 私有构造方法 保证外界无法直接实例化
     */
    private MultiKeyGenerator(String keyName) {
        keyInfo = new KeyInfo(POOL_SIZE, keyName);
    }

    /**
     * 获取实例
     * @return
     */
    public static MultiKeyGenerator getInstance(String keyName) {
        MultiKeyGenerator multiKeyGenerator;
        if(multiKeyGenerators.containsKey(keyName)) {
            multiKeyGenerator = (MultiKeyGenerator) multiKeyGenerators.get(keyName);
        }else {
            multiKeyGenerator = new MultiKeyGenerator(keyName);
            multiKeyGenerators.put(keyName, multiKeyGenerator);
        }
        return multiKeyGenerator;
    }

    public Integer getNext() {
        return keyInfo.getNext();
    }


}
