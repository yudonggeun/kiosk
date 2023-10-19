package com.example.state;

import com.example.domain.Cart;
import com.example.domain.Order;
import com.example.domain.Store;
import com.example.domain.menu.Menu;

public class State {

//    MAIN,
//    PRODUCTS, PRODUCT_OPTION, PRODUCT_PROCESS,
//    COMMAND_ORDER, COMMAND_ORDER_PROCESS,
//    COMMAND_CANCEL, COMMAND_CANCEL_PROCESS;

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

    public String page() {
        return null;
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
