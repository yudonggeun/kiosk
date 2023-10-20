package com.example.domain.menu;

import com.example.domain.menu.template.LeafMenu;
import com.example.domain.menu.template.Menu;
import com.example.page.CommandCancelAcceptPage;
import com.example.page.CommandCancelPage;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.state.State;

public class CommandCancelMenu extends LeafMenu {

    public CommandCancelMenu(String name, String description, Menu nextMenu) {
        super(description, name, nextMenu);
    }

    @Override
    public Page page(State state) {
        return new CommandCancelPage();
    }

    @Override
    public Page process(String command, State state) {
        if (command.equals("1.확인")) {
            state.cart.clear();
            state.menu = nextMenu;
            state.redirect();
            return new CommandCancelAcceptPage();
        } else if (command.equals("2.취소")) {
            state.menu = nextMenu;
            return new HomePage(state);
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}