package com.example.menu.factory;

import com.example.domain.Option;
import com.example.domain.Product;
import com.example.menu.OptionMenu;
import com.example.menu.ProductMenu;
import com.example.menu.template.Menu;

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
