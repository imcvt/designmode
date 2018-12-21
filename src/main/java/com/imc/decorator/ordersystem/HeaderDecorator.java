package com.imc.decorator.ordersystem;

/**
 * @author luoly
 * @date 2018/12/20 16:34
 * @description
 */
public class HeaderDecorator extends OrderDecorator{

    public HeaderDecorator(Order anOrder) {
        super(anOrder);
    }

    public void print() {
        this.printHeader();
        super.order.print();
    }

    private void printHeader() {
        System.out.println("\t***\tI N V O I C E \t***");
        System.out.println("XYZ Incorporated \nDate of Sale:");
        System.out.println(order.getSalesDate());
        System.out.println("=================================");
        System.out.println("Item\t\tUnits\tUnit Price\tSubtotal");
    }
}
