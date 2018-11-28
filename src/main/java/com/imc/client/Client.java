package com.imc.client;

import com.imc.contructure.service.QueryRunner;
import com.imc.contructure.service.impl.SybaseQueryRunner;
import com.imc.singleton.RegSingleton;
import com.imc.singleton.RegSingletonChild;
import com.imc.singleton.repository.SupplierSingleton;

import java.sql.ResultSet;
import java.util.Collections;

/**
 * @author luoly
 * @date 2018/11/27 10:48
 * @description
 */
public class Client {

    public static void main(String[] args) {
//        testQueryRunner();
        regSingleton();
    }

    /**
     * 工厂方法模式
     */
    public static void testQueryRunner() {
        QueryRunner queryRunner = new SybaseQueryRunner();
        try {
            ResultSet resultSet = queryRunner.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例模式
     */
    public static void singleton() {
        SupplierSingleton supplierSingleton = SupplierSingleton.getInstance();
        System.out.println(supplierSingleton);

        //第二个实例和上面是同一个
        SupplierSingleton supplierSingleton1 = SupplierSingleton.getInstance();
        System.out.println(supplierSingleton1);
    }

    /**
     * 登记式单例模式
     */
    public static void regSingleton() {
        RegSingleton regSingleton = RegSingleton.getInstance("com.imc.singleton.RegSingleton");
        RegSingletonChild regSingletonChild = RegSingletonChild.getInstance();
        System.out.println("p-->"+regSingleton);
        System.out.println("c-->"+regSingletonChild);

        //此处会报编译错误，因为构造器为私有，不允许直接这样创建实例
//        RegSingletonChild regSingletonChild1 = new RegSingletonChild();

        //此处运行会报错，因为child子类的构造器不是public的，参见父类中写法可避免
//        try {
//            System.out.println("c1" + RegSingletonChild.class.newInstance());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
