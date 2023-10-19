package com.example.domain.factory;

import com.example.domain.menu.OptionMenu;
import com.example.domain.menu.ProductMenu;
import com.example.domain.Option;
import com.example.domain.Product;

public class ProductMenuFactory {

    public static ProductMenuFactory of(Product product) {
        return new ProductMenuFactory(product);
    }

    private ProductMenuFactory(Product product) {
        this.product = product;
        productMenu = new ProductMenu(product);
    }

    private final Product product;
    private final ProductMenu productMenu;

    public ProductMenu getProductMenu() {
        return productMenu;
    }

    public ProductMenuFactory option(String name, int additionalFee, String... commands){
        var optionMenu = new OptionMenu(new Option(name, additionalFee, product));
        for (String command : commands) {
            productMenu.addOption(command, optionMenu);
        }
        return this;
    }
}
