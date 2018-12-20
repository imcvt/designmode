package com.imc.decorator;

/**
 * @author luoly
 * @date 2018/12/19 14:48
 * @description
 */
public class ConcreteDecorator1 extends Decorator{

    public ConcreteDecorator1(Decorator decorator) {
        super(decorator);
    }

    @Override
    public void sampleOperation() {
        System.out.println("op1--");
        super.sampleOperation();
    }
}
