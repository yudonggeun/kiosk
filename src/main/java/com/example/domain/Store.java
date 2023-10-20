package com.example.domain;

import com.example.Client.Client;
import com.example.menu.CategoryMenu;
import com.example.menu.CommandCancelMenu;
import com.example.menu.CommandOrderMenu;
import com.example.menu.HomeMenu;
import com.example.menu.factory.CategoryMenuFactory;
import com.example.menu.factory.ProductMenuFactory;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.service.Manager;
import com.example.service.OrderService;
import com.example.state.State;

public class Store {

    public static final Manager manager = new Manager();
    public static final SaleHistory record = new SaleHistory();
    public final HomeMenu main;

    public String request(String command, Client client) {
        try {
            State state = client.getState();
            var page = manager.handle(command, state);
            return page.render();
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

    public Store() {

        main = new HomeMenu();
        //product
        var burgerA = new Product("burgerA", "burgetA good", 10000);
        var burgerB = new Product("burgerB", "burgetB good", 11000);

        var pizzaA = new Product("pizzaA", "burgetA good", 10000);
        var pizzaB = new Product("pizzaB", "burgetB good", 11000);

        // product factory
        var product1 = ProductMenuFactory.of(burgerA, main)
                .option("single", 0, "1", "single")
                .option("double", 1000, "2", "double");

        var product2 = ProductMenuFactory.of(burgerB, main)
                .option("single", 0, "1", "single")
                .option("double", 1000, "2", "double");

        var product3 = ProductMenuFactory.of(pizzaA, main)
                .option("large", 10000, "1")
                .option("medium", 0, "2");

        var product4 = ProductMenuFactory.of(pizzaB, main)
                .option("large", 10000, "1")
                .option("medium", 0, "2");

        // category menu
        var subMenu1 = new CategoryMenu("burger", "test")
                .addProductMenu(product1, "1", "burgerA")
                .addProductMenu(product2, "2", "burgerB");

        var subMenu2 = new CategoryMenu("pizza", "test")
                .addProductMenu(product3, "1")
                .addProductMenu(product4, "2");

        // order menu
        main
                .addMenu(CategoryMenuFactory.of("category1")
                        .addCategory(subMenu1, "1", "burger", "1.burger")
                        .addCategory(subMenu2, "2", "pizza", "2.pizza")
                )
                .addMenu(CategoryMenuFactory.of("order")
                        .addCategory(new CommandOrderMenu("order", "장바구니 주문", main), "3", "장바구니 주문")
                        .addCategory(new CommandCancelMenu("cancel", "취소", main), "4", "취소")
                )
        ;
    }
}