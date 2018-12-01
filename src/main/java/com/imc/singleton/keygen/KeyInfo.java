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
    private Integer currentMax = 0;

    /**
     * 当前值
     */
    private Integer current = 0;

    public KeyInfo(Integer poolSize) {
        this.POOL_SIZE = poolSize;
        retrieveFromDB();
    }

    public Integer getNext() {
        if(current == currentMax) {
            currentMax = retrieveFromDB();
        }
        current ++;
        return current;
    }

    private Integer retrieveFromDB() {
        String keyName = "name1";
        String sql1 = " select keyvalue from gentable where keyname = " + keyName;
        String sql2 = " update gentable set keyvalue = " + currentMax + "where keyname = " + keyName;

//        jdbcTemplate.executeSql(sql1) 假设得到1000
        currentMax = 1000;
        current = currentMax;
        currentMax += POOL_SIZE;
        //把最新的值更新
//        jdbcTemplate.executeSql(sql2)

        return currentMax;
    }

}
