package com.imc.decorator.ordersystem;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Vector;

/**
 * @author luoly
 * @date 2018/12/20 16:33
 * @description
 */
public abstract class Order {
    private OrderLine lnkOrderLine;
    protected String costomerName;
    protected Date salesDate;
    protected Vector items = new Vector(10);

    public void print() {
        for(int i=0; i<items.size(); i++) {
            OrderLine item = (OrderLine) items.get(i);
            item.printLine();
        }
    }

    public void addItem(OrderLine orderLine) {
        items.add(orderLine);
    }

    public void removeItem(OrderLine orderLine) {
        items.remove(orderLine);
    }

    public double getGrandTotal() {
        double amnt = 0.0D;
        for(int i=0; i<items.size(); i++) {
            OrderLine item = (OrderLine) items.get(i);
            amnt += item.getSubtotal();
        }
        return amnt;
    }

    /**
     * 格式化货币
     * @param amnt
     * @return
     */
    protected String formatCurrency(double amnt) {
        return NumberFormat.getCurrencyInstance().format(amnt);
    }

    public OrderLine getLnkOrderLine() {
        return lnkOrderLine;
    }

    public void setLnkOrderLine(OrderLine lnkOrderLine) {
        this.lnkOrderLine = lnkOrderLine;
    }

    public String getCostomerName() {
        return costomerName;
    }

    public void setCostomerName(String costomerName) {
        this.costomerName = costomerName;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }
}
