package com.imc.contructure.simpledemo;

/**
 * @author luoly
 * @date 2018/12/4 11:32
 * @description
 */
public class ConcreteBuilder2 extends Builder{

    private Product product = new Product2();

    public void buildPart1() {
        System.out.println("buildPart1--");
    }

    public void buildPart2() {
        System.out.println("buildPart2--");
    }

    public Product retrieveProduct() {
        System.out.println("product2 complete ! ");
        return product;
    }
}
