package com.example.menu;

import com.example.menu.template.LeafMenu;
import com.example.menu.template.Menu;
import com.example.page.CommandCancelAcceptPage;
import com.example.page.CommandCancelPage;
import com.example.page.HomePage;
import com.example.state.State;

public class CommandCancelMenu extends LeafMenu {

    public CommandCancelMenu(String name, String description, Menu nextMenu) {
        super(name, description, nextMenu);
    }

    @Override
    public String page(State state) {
        return new CommandCancelPage().render();
    }

    @Override
    public String process(String command, State state) {
        if (command.equals("1.확인") || command.equals("1")) {
            state.cart.clear();
            state.menu = nextMenu;
            state.redirect();
            return new CommandCancelAcceptPage().render();
        } else if (command.equals("2.취소") || command.equals("2")) {
            state.menu = nextMenu;
            return new HomePage(state).render();
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}