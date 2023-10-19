package com.example.domain.menu;

import com.example.domain.product.Option;
import com.example.domain.product.Product;
import com.example.page.Page;
import com.example.page.ProductOptionPage;
import com.example.state.State;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductMenu extends Menu {

    private final Product product;
    private final Set<Option> options = new LinkedHashSet<>();

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

    @Override
    public Page page(State state) {
        return new ProductOptionPage(state);
    }

    public Product product() {
        return product;
    }

    public Set<Option> options() {
        return options;
    }
}
