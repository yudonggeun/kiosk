package org.example.domain.option;

import org.example.domain.Menu;
import org.example.domain.State;
import org.example.domain.menu.MenuList;

public class Order extends Option{
    public Order(int order) {
        super(order, "Order", "장바구니를 확인 후 주문합니다.");
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var context = State.context();

        sb.append("아래와 같이 주문 하시겠습니까?\n");
        sb.append(context.receipt());
        return sb.toString();
    }

    public Order onPay(Menu backPage){
        addListener("1.주문", () -> {
            State context = State.context();
            System.out.println("주문이 완료되었습니다.");

            System.out.println("대기번호는 [ 미구현 ] 번 입니다.");
            System.out.println("(3초후 메뉴판으로 돌아갑니다.)\n");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            context.setMenu(backPage);
        });
        return this;
    }

    public Order onMenu(MenuList backPage) {
        addListener("2.메뉴판", () -> {
            State context = State.context();
            context.setMenu(backPage);
        });
        return this;
    }
}
