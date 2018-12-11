package com.imc.prototype;

import com.imc.contructure.simpledemo.ConcreteBuilder1;

/**
 * @author luoly
 * @date 2018/12/11 10:13
 * @description
 */
public class ConcreteProtoType implements ProtoType{

    private String name;
    private int age;
    private ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ConcreteBuilder1 getConcreteBuilder1() {
        return concreteBuilder1;
    }

    public void setConcreteBuilder1(ConcreteBuilder1 concreteBuilder1) {
        this.concreteBuilder1 = concreteBuilder1;
    }
}
