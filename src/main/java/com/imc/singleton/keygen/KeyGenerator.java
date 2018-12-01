package com.imc.singleton.keygen;

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
     * 私有构造方法 不允许外界创建 把keyIfo放在单例类的初始化方法中，keyInfo对象在当前对象中也是唯一的
     */
    private KeyGenerator() {
        keyInfo = new KeyInfo(20);
    }

    /**
     * 获取唯一实例
     * @return
     */
    public static KeyGenerator getInstance() {
        return keyGenerator;
    }

    public synchronized Integer getNext() {
        return keyInfo.getNext();
    }

}
