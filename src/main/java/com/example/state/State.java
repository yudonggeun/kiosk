package com.example.state;

import com.example.domain.Cart;
import com.example.domain.Order;
import com.example.domain.Store;
import com.example.domain.menu.Menu;

public class State {

    public static State create() {
        State state = new State();
        state.setMenu(Store.main);
        return state;
    }
    private Menu menu;

    private final Cart cart = new Cart();
    private boolean isWait = false;
    private boolean needMain = false;

    public void setMenu(Menu menu){
        this.menu = menu;
    }

    public Cart getCart() {
        return cart;
    }

    public void addOrder(Order order) {
        cart.addOrder(order);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setWait(boolean isWait) {
        this.isWait = isWait;
    }

    public boolean isWait() {
        return isWait;
    }

    public void setNeedMain(boolean needMain){
        this.needMain = needMain;
    }
    public boolean needMain() {
        return needMain;
    }
}
