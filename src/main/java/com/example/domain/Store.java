package com.example.domain;

import com.example.Client.Client;
import com.example.domain.menu.*;
import com.example.domain.product.Option;
import com.example.domain.product.Product;
import com.example.page.MainPage;
import com.example.service.Manager;
import com.example.state.State;

public class Store {

    public static final Store store = new Store();
    public static Manager manager = new Manager();
    public static SaleHistory record = new SaleHistory();
    public static MainMenu main;

    public String request(String command, Client client) {
        try {
            State state = client.getState();
            var page = manager.handle(state.getMenu(), command, state);
            return page.render();
        } catch (RuntimeException e) {
            return command + " : 잘못된 입력입니다.";
        }
    }

    public String mainPage() {
        return new MainPage(Store.main).render();
    }

    public Store() {
        main = MainMenu.single()
                .addMenu("category1",
                        new CategoryMenu("burger", "test", "1")
                                .addMenu(
                                        new ProductMenu(new Product("product1", "test", 1000), "1")
                                                .addOption(
                                                        new OptionMenu(new Option("single", 0, new Product("product1", "test", 1000)), "1"),
                                                        new OptionMenu(new Option("Double", 1000, new Product("product1", "test", 1000)), "2")
                                                )
                                ),

                        new CategoryMenu("pizza", "test", "2")
                                .addMenu(
                                        new ProductMenu(new Product("product1", "test", 1000), "1")
                                                .addOption(
                                                        new OptionMenu(new Option("single", 0, new Product("product1", "test", 1000)), "1"),
                                                        new OptionMenu(new Option("Double", 1000, new Product("product1", "test", 1000)), "2")
                                                )
                                )
                )
                .addMenu("order",
                        new CommandOrderMenu("order", "장바구니 주문", "3"),
                        new CommandCancelMenu("cancel", "취소", "4")
                )
        ;
    }
}