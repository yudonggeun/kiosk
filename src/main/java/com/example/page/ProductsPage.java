package com.example.page;

import com.example.Property;
import com.example.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage implements Page {

    private String subject;

    private final List<Product> products = new ArrayList<>();

    public ProductsPage(String subject) {
        this.subject = subject;
    }

    public ProductsPage addProduct(Product... product){
        products.addAll(List.of(product));
        return this;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(Property.WELCOME)
                .append(Property.PRODUCT_GUIDE)
                .append("\n")
                .append(String.format("[ %s MENU ]\n", subject));

        int order = 0;
        for (var product : products) {
            sb.append(String.format("%d. %-10s | %10d원 | %s\n", ++order, product.name(), product.price(), product.description()));
        }
        sb.append("\n");
        return sb.toString();
    }

}
