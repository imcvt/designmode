package com.imc.client;

import com.imc.contructure.service.QueryRunner;
import com.imc.contructure.service.impl.SybaseQueryRunner;
import com.imc.contructure.simpledemo.Director;
import com.imc.contructure.simpledemo.Product;
import com.imc.contructure.simpledemo.Product1;
import com.imc.prototype.ConcreteProtoType;
import com.imc.prototype.ProtoType;
import com.imc.singleton.RegSingleton;
import com.imc.singleton.RegSingletonChild;
import com.imc.singleton.keygen.KeyGenerator;
import com.imc.singleton.keygen.MultiKeyGenerator;
import com.imc.singleton.repository.SupplierSingleton;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.Date;

/**
 * @author luoly
 * @date 2018/11/27 10:48
 * @description
 */
public class Client {

    /**
     * 工厂方法模式
     */
    @Test
    public void testQueryRunner() {
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
    @Test
    public void singleton() {
        SupplierSingleton supplierSingleton = SupplierSingleton.getInstance();
        System.out.println(supplierSingleton);

        //第二个实例和上面是同一个
        SupplierSingleton supplierSingleton1 = SupplierSingleton.getInstance();
        System.out.println(supplierSingleton1);
    }

    /**
     * 登记式单例模式
     */
    @Test
    public void regSingleton() {
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

    @Test
    public void testKeyGenerator() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance();
//        MultiKeyGenerator keyGenerator = MultiKeyGenerator.getInstance();
        for (int i = 0; i < 30; i++) {
            if(i < 25) {
                System.out.println(keyGenerator.getNext("po1"));
            }else {
                System.out.println(keyGenerator.getNext("po2"));
            }
        }
    }

    @Test
    public void testMulKeyGenerator() {
        MultiKeyGenerator keyGenerator = MultiKeyGenerator.getInstance("po1");
        MultiKeyGenerator keyGenerator2 = MultiKeyGenerator.getInstance("po2");
        for (int i = 0; i < 30; i++) {
            if(i < 25) {
                System.out.println(keyGenerator.getNext());
            }else {
                System.out.println(keyGenerator2.getNext());
            }
        }
    }

    @Test
    public void testSimpleConstruct() {
        Director director = new Director();
        director.construct();
        Product1 product1 = new Product1();

        System.out.println(product1.p);
    }

    @Test
    public void testClone() {
        ConcreteProtoType protoType = new ConcreteProtoType();
        protoType.setName("bee");
        protoType.setAge(23);
        ProtoType protoType1 = (ProtoType) protoType.clone();
        System.out.println("用父类接收克隆出的对象-->" + protoType1);

        ConcreteProtoType protoType2 = (ConcreteProtoType) protoType1;
        System.out.println("取出克隆对象的属性-->name="+protoType2.getName()+",age=" + protoType2.getAge());

        System.out.println(0.1 + 0.2);
    }
}
