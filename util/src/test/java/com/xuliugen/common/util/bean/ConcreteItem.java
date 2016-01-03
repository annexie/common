package com.xuliugen.common.util.bean;

public class ConcreteItem extends Item {

    private double price;

    public ConcreteItem(int id, String name) {
        super(id, name);
    }

    public ConcreteItem(int id, String name, boolean disabled) {
        super(id, name, disabled);
    }

    @Deprecated
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
