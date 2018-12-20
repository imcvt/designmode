package com.imc.decorator;

/**
 * @author luoly
 * @date 2018/12/19 14:15
 * @description
 */
public class Decorator implements Component{
    private Component component;

    /**
     * 有参构造
     * @param component
     */
    public Decorator(Component component) {
        this.component = component;
    }

    /**
     * 无参构造
     */
    public Decorator() {

    }

    @Override
    public void sampleOperation() {
        System.out.println("接口op");
        component.sampleOperation();
    }
}
