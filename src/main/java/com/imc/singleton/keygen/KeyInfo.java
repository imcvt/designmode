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


    public KeyInfo(Integer poolSize) {
        this.POOL_SIZE = poolSize;
        retrieveFromDB();
    }

    public Integer getNext() {
        System.out.println(current + "--" + max);
        //这里不能用==，Integer封装类型不能直接用==比较
        if(current.intValue() == max.intValue()) {
            retrieveFromDB();
        }
        return current ++;
    }

    private Integer retrieveFromDB() {
        System.out.println("--");
        String keyName = "name1";
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
