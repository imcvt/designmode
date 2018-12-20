package com.imc.decorator;

/**
 * @author luoly
 * @date 2018/12/19 14:48
 * @description
 */
public class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Decorator decorator) {
        super(decorator);
    }

    @Override
    public void sampleOperation() {
        System.out.println("op2--");
        super.sampleOperation();
    }
}
