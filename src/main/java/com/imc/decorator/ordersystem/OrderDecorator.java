package com.imc.decorator.ordersystem;

/**
 * @author luoly
 * @date 2018/12/20 16:34
 * @description
 */
public class OrderDecorator extends Order{
    protected Order order;

    public OrderDecorator(Order order) {
        this.order = order;
        this.setSalesDate(order.getSalesDate());
        this.setCostomerName(order.getCostomerName());

    }

    public void print() {
        super.print();
    }
}
