package com.imc.contructure.simpledemo;

/**
 * @author luoly
 * @date 2018/12/4 11:31
 * @description
 */
public class Director {
    private Builder builder;

    public void construct() {
        builder = new ConcreteBuilder1();
        builder.buildPart1();
        builder.buildPart2();
        builder.retrieveProduct();
    }
}
