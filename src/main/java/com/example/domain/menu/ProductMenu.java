package com.example.domain.menu;

import com.example.domain.product.Option;
import com.example.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMenu extends ParentMenu<OptionMenu>{

    private final Product product;
    private final List<Option> options = new ArrayList<>();

    public ProductMenu(Product product, String... commands) {
        super(product.name(), product.description(), commands);
        this.product = product;
    }

    public ProductMenu addOption(OptionMenu... options) {
        for (var menu : options) {
            this.options.add(menu.option());
            addMenu(menu);
        }
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

    public List<Option> options(){
        return options;
    }
}
