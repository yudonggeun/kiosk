package org.example.domain.option;

import org.example.domain.Menu;
import org.example.domain.State;

public class Cancel extends Option{
    public Cancel(int order) {
        super(order,"Cancel", "진행중인 주문을 취소합니다.");
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("진행하던 주문을 취소하시겠습니까?\n");
        sb.append(String.format("%-10s %s", "1.확인", "2.취소"));
        return sb.toString();
    }

    public Cancel onClear(Menu backPage) {
        addListener("1.확인", () -> {
            State context = State.context();
            context.clear();
            System.out.println("진행하던 주문이 취소되었습니다.\n");
            context.setMenu(backPage);
        });
        return this;
    }

    public Cancel onMenu(Menu backPage) {
        addListener("2.취소", () -> {
            State context = State.context();
            context.setMenu(backPage);
        });
        return this;
    }
}
