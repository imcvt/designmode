package com.imc.singleton.repository;

import java.util.Date;

/**
 * @author luoly
 * @date 2018/10/23 11:42
 * @description
 */
public class SupplierSingleton{

    private static SupplierSingleton supplierSingleton = new SupplierSingleton();

    private SupplierSingleton() {
    }

    /**
     * 单例
     * @return
     */
    public static SupplierSingleton getInstance() {
        return supplierSingleton;
    }

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
