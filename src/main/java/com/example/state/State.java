package com.example.state;

import com.example.domain.Cart;
import com.example.domain.Order;
import com.example.domain.Store;
import com.example.domain.menu.Menu;
import com.example.page.Page;
import com.example.service.OrderService;

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

    public Cart getCart() {
        return cart;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }

    public void setWait(boolean isWait) {
        if(!isWait) OrderService.quit();
        this.isWait = isWait;
    }

    public void setNeedMain(boolean needMain){
        this.needMain = needMain;
    }

    public void addOrder(Order order) {
        cart.addOrder(order);
    }

    public boolean isWait() {
        return isWait;
    }
    public boolean needMain() {
        return needMain;
    }

    public Page page() {
        return menu.page(this);
    }
}
