package com.example.page;

import com.example.config.Property;
import com.example.menu.CategoryMenu;
import com.example.menu.ProductMenu;
import com.example.state.State;

public class ProductListPage implements Page {

    private final CategoryMenu menu;


    public ProductListPage(State state) {
        this.menu = (CategoryMenu) state.menu;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(Property.WELCOME)
                .append(Property.PRODUCT_GUIDE)
                .append("\n")
                .append(String.format("[ %s MENU ]\n", menu.name()));

        int order = 0;
        for (var product : menu.products()) {
            sb.append(String.format("%d. %-10s | %10d원 | %s\n", ++order, product.name(),((ProductMenu) product).price(), product.description()));
        }
        sb.append("\n");
        return sb.toString();
    }

}
