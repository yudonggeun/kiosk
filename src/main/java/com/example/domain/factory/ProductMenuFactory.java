package com.example.domain.factory;

import com.example.domain.Option;
import com.example.domain.Product;
import com.example.domain.menu.OptionMenu;
import com.example.domain.menu.ProductMenu;
import com.example.domain.menu.template.Menu;

public class ProductMenuFactory {

    public static ProductMenuFactory of(Product product, Menu nextMenu) {
        return new ProductMenuFactory(product, nextMenu);
    }
    private final Menu nextMenu;

    private ProductMenuFactory(Product product, Menu nextMenu) {
        this.product = product;
        productMenu = new ProductMenu(product);
        this.nextMenu = nextMenu;
    }

    private final Product product;
    private final ProductMenu productMenu;

    public ProductMenu getProductMenu() {
        return productMenu;
    }

    public ProductMenuFactory option(String name, int additionalFee, String... commands){
        var optionMenu = new OptionMenu(new Option(name, additionalFee, product), nextMenu);
        for (String command : commands) {
            productMenu.addOption(command, optionMenu);
        }
        return this;
    }
}
