package com.imc.singleton.repository;

import java.util.Date;

/**
 * @author luoly
 * @date 2018/10/23 11:42
 * @description
 */
public class SupplierSingleton{

    /**
     * 饿汉式
     */
    private static SupplierSingleton supplierSingleton = new SupplierSingleton();
    /**
     * 懒汉式
     */
    private static SupplierSingleton supplierSingleton1 = null;

    private static SupplierSingleton supplierSingleton2 = null;

    private SupplierSingleton() {
    }

    /**
     * 单例
     * @return
     */
    public static SupplierSingleton getInstance() {
        return supplierSingleton;
    }
    /**
     * 单例2
     * @return
     */
    public synchronized SupplierSingleton getInstance1() {
        if(null == supplierSingleton1) {
            supplierSingleton1 = new SupplierSingleton();
        }
        return supplierSingleton1;
    }

    /**
     * 双重检查在java语言中不支持，原因是SupplierSingleton与supplierSingleton1变量赋值的顺序不可预料
     * @return
     */
//    public static SupplierSingleton getInstance2() {
//        if(null == supplierSingleton2) {
//            synchronized (this) {
//                if (null == supplierSingleton2) {
//                    supplierSingleton2 = new SupplierSingleton();
//                }
//            }
//        }
//        return supplierSingleton2;
//    }

    private Long id; // 主键ID
    private String name; // 姓名
    private Date createTime;
    private Integer sex;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
