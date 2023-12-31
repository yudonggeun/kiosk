package com.example.state;

import com.example.domain.Cart;
import com.example.domain.Order;
import com.example.menu.template.Menu;

public class State {

    public static State create(Menu mainMenu) {
        State state = new State();
        state.menu = mainMenu;
        return state;
    }

    public Menu menu;
    public final Cart cart = new Cart();
    private boolean isWait = false;
    private boolean isRedirect = false;

    public void addOrder(Order order) {
        cart.addOrder(order);
    }

    public void block() {
        isWait = true;
        isRedirect = true;
    }

    public boolean buffering() {
        if (isWait) {
            isWait = false;
            return true;
        }
        return false;
    }

    public void redirect() {
        isRedirect = true;
    }

    public boolean isRedirect() {
        if (isRedirect) {
            isRedirect = false;
            return true;
        }
        return false;
    }

    public String process(String command) {
        return menu.process(command, this);
    }

    public String page() {
        return menu.page(this);
    }
}
