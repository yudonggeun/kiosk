package com.example.store;

import com.example.domain.SaleHistory;
import com.example.menu.HomeMenu;
import com.example.page.HomePage;
import com.example.service.Manager;
import com.example.service.OrderService;
import com.example.state.State;

public abstract class Store {

    public static final Manager manager = new Manager();
    public static final SaleHistory record = new SaleHistory();
    public final HomeMenu main;

    public Store() {
        main = new HomeMenu();
        init();
    }

    public String request(String command, State state) {
        try {
            return manager.handle(command, state);
        } catch (RuntimeException e) {
            return command + " : 잘못된 입력입니다.";
        }
    }

    public void buffering(State state) {
        if (state.buffering()) {
            stop(3);
            OrderService.quit();
        }
    }

    public String homePage(State state) {
        state.menu = main;
        return new HomePage(state).render();
    }

    public String reload(State state) {
        return state.page();
    }

    private void stop(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void init();
}