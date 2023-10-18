package org.example.domain.menu;

import org.example.domain.Menu;
import org.example.domain.State;

import java.util.Map;
import java.util.TreeMap;

public class MainPage extends MenuList {

    private static String guide = "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요";
    private final Map<Integer, MenuList> subMenus = new TreeMap<>();

    public MainPage(String name, String description) {
        super(name, description, -1);
    }


    public MainPage add(MenuList... subList) {
        for (MenuList sub : subList) {
            this.subMenus.put(sub.getOrder(), sub);
            for (Menu menu : sub.getMenus()) {
                addListener(menu.getCommand(), () -> State.context().setMenu(menu));
            }
        }
        return this;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder()
                .append(State.guideMessage()).append("\n")
                .append(guide).append("\n\n");

        for (MenuList menuList : subMenus.values()) {
            sb.append(String.format("[ %s MENU ]", menuList.getName())).append("\n");
            for (Menu menu : menuList.getMenus()) {
                sb.append(menu.toMenuString()).append("\n");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
