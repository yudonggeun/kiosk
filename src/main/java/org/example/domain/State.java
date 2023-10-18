package org.example.domain;

import org.example.domain.product.Product;

import java.util.HashMap;
import java.util.Map;

public class State {

    private Menu menu;
    private Map<Product, Integer> productMap = new HashMap<>();

    private static State state = new State();
    private static String guideMessage = "환영합니다. 다음 메뉴를 참고해주세요.";

    public static State context() {
        return state;
    }

    public static String guideMessage(){
        return guideMessage;
    }

    public void put(Product product, int count) {
        productMap.putIfAbsent(product, count);
        productMap.computeIfPresent(product, (p, c) -> c + count);
    }

    public void clear() {
        productMap.clear();
    }

    public void print() {
        System.out.println(menu);
    }

    public void run(String command) {
        menu.run(command);
    }

    public void setMenu(Menu subMenu) {
        this.menu = subMenu;
    }

    public String receipt() {
        var receipt = new StringBuilder();
        int totalPrice = 0;
        receipt.append("[ Orders ]\n");
        for (var entry : productMap.entrySet()) {
            Product product = entry.getKey();
            int count = 1;
            receipt.append(product).append("\n");
            totalPrice += product.getPrice() * count;
        }

        receipt.append("\n");
        receipt.append("[ Total ]\n");
        receipt.append(totalPrice+"원\n");
        receipt.append("\n");

        receipt.append(String.format("%-10s %s", "1.주문", "2.메뉴판"));
        return receipt.toString();
    }
}
