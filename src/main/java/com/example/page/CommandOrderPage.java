package com.example.page;

import com.example.domain.Cart;
import com.example.domain.Product;

import java.util.Map;

public class CommandOrderPage implements Page {

    private final Cart cart;

    public CommandOrderPage(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append("아래와 같이 주문 하시겠습니까?\n\n")
                .append("[ Orders ]\n");

        Map<Product, Integer> map = cart.listMap();
        map.forEach((product, count) -> {
            sb.append(String.format("%-10s | %10d원 | %5d개 | %s\n", product.name(), product.price(), count, product.description()));
        });

        sb.append("\n")
                .append("[ Total ]\n")
                .append(cart.totalPrice() + "원\n")
                .append("\n")
                .append("1. 주문      2. 메뉴판\n")
        ;

        return sb.toString();
    }
}
