package com.imc.singleton.keygen;

/**
 * @author luoly
 * @date 2018/12/1 15:18
 * @description
 */
public class KeyInfo {

    /**
     * 缓存的个数
     */
    private Integer POOL_SIZE = 20;

    /**
     * 当前可用的最大值
     */
    private Integer max = 0;

    /**
     * 当前值
     */
    private Integer current = 0;
    /**
     * 最小值
     */
    private Integer min = 0;

    /**
     * 主键值，区分不同的主键，这里用了成员变量而不是作为方法的入参，是考虑到keyName对于KeyInfo的实例来说是个属性
     */
    private String keyName = "";


    public KeyInfo(Integer poolSize, String keyName) {
        this.POOL_SIZE = poolSize;
        this.keyName = keyName;
        retrieveFromDB();
    }

    public Integer getNext() {
        //这里不能用==，Integer封装类型不能直接用==比较，而且用了==之后会导致每次相等的时候被初始化，比如当current=1020时，会被初始化成1000，本
        //该输出1020，结果输出了1001
        if(current.intValue() > max.intValue()) {
            retrieveFromDB();
        }
        return current ++;
    }

    private Integer retrieveFromDB() {
        String sql1 = " select keyvalue from gentable where keyname = " + keyName;
        String sql2 = " update gentable set keyvalue = " + max + "where keyname = " + keyName;

//        jdbcTemplate.executeSql(sql1) 假设得到1000
        min = 1000;
        current = min + 1;
        max = min + POOL_SIZE;
        //把最新的值更新
//        jdbcTemplate.executeSql(sql2)

        return current;
    }

}
