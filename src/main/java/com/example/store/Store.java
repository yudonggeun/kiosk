package com.example.store;

import com.example.Client.Client;
import com.example.domain.SaleHistory;
import com.example.menu.HomeMenu;
import com.example.page.HomePage;
import com.example.page.Page;
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

    public String request(String command, Client client) {
        try {
            State state = client.getState();
            return manager.handle(command, state)
                    .render();
        } catch (RuntimeException e) {
            return command + " : 잘못된 입력입니다.";
        }
    }

    public void buffering(Client client) {
        if (client.getState().buffering()) {
            stop(3);
            OrderService.quit();
        }
    }

    public String homePage(Client client) {
        client.getState();
        client.setMenu(main);
        return new HomePage(client.getState()).render();
    }

    public String reload(Client client){
        Page page = client.getState().menu.page(client.getState());
        return page.render();
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