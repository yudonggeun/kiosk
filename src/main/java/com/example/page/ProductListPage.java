package com.example.page;

import com.example.Property;
import com.example.domain.menu.CategoryMenu;
import com.example.domain.menu.ProductMenu;

public class ProductListPage implements Page {

    private CategoryMenu menu;


    public ProductListPage(CategoryMenu menu) {
        this.menu = menu;
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
