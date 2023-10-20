package com.example.menu;

import com.example.menu.template.LeafMenu;
import com.example.menu.template.Menu;
import com.example.page.Page;
import com.example.state.State;

public class BackMenu extends LeafMenu {
    private final Menu nextMenu;

    public BackMenu(Menu nextMenu) {
        super("", "", nextMenu);
        this.nextMenu = nextMenu;
    }
    @Override
    public String page(State state) {
        return nextMenu.page(state);
    }

    @Override
    public String process(String command, State state) {
        if (command.equals("1.돌아가기") || command.equals("1")) {
            state.menu = nextMenu;
            return state.page();
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}
