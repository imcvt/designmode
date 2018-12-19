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
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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

    @Test
    public void testThread() throws Exception{

        long time = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("准备面条--");
                    Thread.sleep(1000*3);
                    System.out.println("准备面条--结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("准备凉菜--");
                    Thread.sleep(1000*5);
                    System.out.println("准备凉菜--结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long timec = (System.currentTimeMillis() - time)/1000;
        System.out.println(timec);
    }

    @Test
    public void testFuture()throws Exception {
        long time = System.currentTimeMillis();

        Callable ca1 = new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("准备面条");
                Thread.sleep(1000*3);
                return "面条--";
            }
        };
        FutureTask<String> fu1 = new FutureTask<>(ca1);
        Thread t1 = new Thread(fu1);


        Callable ca2 = new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("准备凉菜");
                Thread.sleep(1000*4);
                return "凉菜--";
            }
        };
        FutureTask<String> fu2 = new FutureTask<>(ca2);
        Thread t2 = new Thread(fu2);

        t1.start();
        t2.start();

        System.out.println(fu1.get());
        System.out.println(fu2.get());

        long timec = (System.currentTimeMillis() - time)/1000;
        System.out.println(timec);

    }
}
