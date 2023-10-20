package com.example.menu;

import com.example.domain.Option;
import com.example.domain.Product;
import com.example.menu.template.BranchMenu;
import com.example.page.ProductOptionPage;
import com.example.state.State;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductMenu extends BranchMenu {

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

    public Product getProduct() {
        return product;
    }

    public Set<Option> getOptions() {
        return options;
    }

    @Override
    public String page(State state) {
        return new ProductOptionPage(state).render();
    }
}
