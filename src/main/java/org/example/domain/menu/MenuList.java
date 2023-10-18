package org.example.domain.menu;

import org.example.domain.Menu;
import org.example.domain.State;

import java.util.*;

public class MenuList extends Menu {
    private static String guide = "아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요";
    private final Map<Integer, Menu> subMenus = new TreeMap<>();

    public MenuList(String name, String description, int order) {
        super(order, name, description);
    }

    public MenuList add(Menu... subMenus) {
        for (Menu sub : subMenus) {
            this.subMenus.put(sub.getOrder(), sub);
            addListener(sub.getCommand(), () -> State.context().setMenu(sub));
        }
        return this;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder()
                .append(State.guideMessage()).append("\n")
                .append(guide).append("\n\n")
                .append(String.format("[ %s MENU ]", getName())).append("\n");

        for (Menu menu : subMenus.values()) {
            sb.append(menu.toMenuString()).append("\n");
        }
        return sb.toString();
    }

    public Iterable<Menu> getMenus() {
        return subMenus.values();
    }
}
