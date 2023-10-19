package com.example.domain.menu;

import com.example.domain.product.Option;
import com.example.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMenu extends Menu {

    private final Product product;
    private final List<Option> options = new ArrayList<>();

    public ProductMenu(Product product) {
        super(product.name(), product.description());
        this.product = product;
    }

    public ProductMenu addOption(String command, OptionMenu menu) {
        this.options.add(menu.option());
        addMenu(command, menu);
        return this;
    }

    public int price() {
        return product.price();
    }

    @Override
    public String name() {
        return product.name();
    }

    public Product product() {
        return product;
    }

    public List<Option> options() {
        return options;
    }
}
