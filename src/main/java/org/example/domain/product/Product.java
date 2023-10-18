package org.example.domain.product;

import org.example.domain.Menu;
import org.example.domain.State;
import org.example.domain.menu.MenuList;

public class Product extends Menu {

    private int price;

    public Product(String name, int price, String description, int order) {
        super(order, name, description);
        this.price = price;
    }

    public Product onPurchase(Menu backPage) {
        addListener("1.확인", () -> {
            State context = State.context();
            System.out.println(getName() + "가 장바구니에 추가되었습니다.\n");
            context.put(this, 1);
            context.setMenu(backPage);
        });
        return this;
    }

    public Menu onCancel(MenuList backPage) {
        addListener("2.취소", () -> {
            State context = State.context();
            context.put(this, 1);
            context.setMenu(backPage);
        });
        return this;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(String.format("\"%-10s | %10d원 | %s\"\n", getName(), price, getDescription()));
        sb.append("위 메뉴를 장바구니에 추가하시겠습니까?\n");
        sb.append(String.format("%-10s %s", "1.확인", "2.취소"));
        return sb.toString();
    }

    @Override
    public String toMenuString() {
        return String.format("%d. %-10s | %10d원 | %s", getOrder(), getName(), price, getDescription());
    }
}
