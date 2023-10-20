package com.example.domain.menu;

import com.example.domain.Store;
import com.example.domain.menu.template.LeafMenu;
import com.example.domain.menu.template.Menu;
import com.example.page.CommandOrderAcceptPage;
import com.example.page.CommandOrderPage;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.state.State;

public class CommandOrderMenu extends LeafMenu {

    public CommandOrderMenu(String name, String description, Menu nextMenu) {
        super(description, name, nextMenu);
    }

    @Override
    public Page page(State state) {
        return new CommandOrderPage(state);
    }

    @Override
    public Page process(String command, State state) {
        if (command.equals("1.주문")) {
            var cart = state.cart;
            cart.getOrders().forEach(Store.record::sale);
            cart.clear();
            state.block();
            state.menu = nextMenu;
            return new CommandOrderAcceptPage();
        } else if (command.equals("2.메뉴판")) {
            state.menu = nextMenu;
            return new HomePage(state);
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}
