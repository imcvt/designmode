package com.imc.decorator.ordersystem;

import java.text.NumberFormat;

/**
 * @author luoly
 * @date 2018/12/20 16:36
 * @description
 */
public class OrderLine {

    String itemName;
    int units;
    double unitPrice;

    public void printLine() {
        System.out.println(
                itemName + "\t" + units
                + "\t" + formatCurrency(unitPrice)
                + "\t" + formatCurrency(getSubtotal())
        );
    }

    private String formatCurrency(double amnt) {
        return NumberFormat.getCurrencyInstance().format(amnt);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return unitPrice * units;
    }
}
