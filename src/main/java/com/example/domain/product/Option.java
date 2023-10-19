package com.example.domain.product;

public class Option extends Product{

    private final String name;
    private final Product product;

    public Option(String name, int additionalFee, Product product) {
        super(name, product.description(), product.price() + additionalFee);
        this.name = name;
        this.product = product;
    }

    @Override
    public String name() {
        return product.name() + "(" + name + ")";
    }

    public String optionName(){
        return name;
    }
}
