package com.example.state;

import com.example.domain.Cart;
import com.example.domain.Order;
import com.example.domain.Store;
import com.example.domain.menu.template.Menu;
import com.example.page.Page;

public class State {

    public static State create(Store store) {
        State state = new State();
        state.menu = store.main;
        return state;
    }

    public Menu menu;
    public final Cart cart = new Cart();
    private boolean isWait = false;
    private boolean needMain = false;

    public void addOrder(Order order) {
        cart.addOrder(order);
    }

    public void block(){
        isWait = true;
        needMain = true;
    }

    public boolean buffering() {
        if(isWait){
            isWait = false;
            return true;
        }
        return false;
    }

    public void redirect(){
        needMain = true;
    }
    public boolean isRedirect() {
        if(needMain) {
            needMain = false;
            return true;
        }
        return false;
    }

    public Page page() {
        return menu.page(this);
    }
}
