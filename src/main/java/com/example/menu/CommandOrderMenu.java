package com.example.menu;

import com.example.store.Store;
import com.example.menu.template.LeafMenu;
import com.example.menu.template.Menu;
import com.example.page.CommandOrderAcceptPage;
import com.example.page.CommandOrderPage;
import com.example.page.HomePage;
import com.example.state.State;

public class CommandOrderMenu extends LeafMenu {

    public CommandOrderMenu(String name, String description, Menu nextMenu) {
        super(name, description, nextMenu);
    }

    @Override
    public String page(State state) {
        return new CommandOrderPage(state).render();
    }

    @Override
    public String process(String command, State state) {
        if (command.equals("1.주문") || command.equals("1")) {
            var cart = state.cart;
            cart.getOrders().forEach(Store.record::sale);
            cart.clear();
            state.block();
            state.menu = nextMenu;
            return new CommandOrderAcceptPage().render();
        } else if (command.equals("2.메뉴판") || command.equals("2")) {
            state.menu = nextMenu;
            return new HomePage(state).render();
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}
