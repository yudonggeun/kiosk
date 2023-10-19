package com.example.domain;

import com.example.Client.Client;
import com.example.domain.menu.*;
import com.example.domain.product.Option;
import com.example.domain.product.Product;
import com.example.page.HomePage;
import com.example.service.Manager;
import com.example.state.State;

public class Store {

    public static final Store store = new Store();
    public static final Manager manager = new Manager();
    public static final SaleHistory record = new SaleHistory();
    public static HomeMenu main;

    public String request(String command, Client client) {
        try {
            State state = client.getState();
            var page = manager.handle(command, state);
            return page.render();
        } catch (RuntimeException e) {
            return command + " : 잘못된 입력입니다.";
        }
    }

    public String mainPage(Client client) {
        return new HomePage(client.getState()).render();
    }

    public Store() {

        //product
        var burgerA = new Product("burgerA", "burgetA good", 10000);
        var burgerB = new Product("burgerB", "burgetB good", 11000);

        var pizzaA = new Product("burgerA", "burgetA good", 10000);
        var pizzaB = new Product("burgerB", "burgetB good", 11000);

        var singleBurgerA = new Option("single", 0, burgerA);
        var doubleBurgerB = new Option("Double", 1000, burgerA);

        // option
        var pizzaOptionA = new Option("large", 10000, pizzaA);
        var pizzaOptionB = new Option("medium", 0, pizzaB);

        // option menu
        var singleBurgerAOptionMenu = new OptionMenu(singleBurgerA);
        var doubleBurgerAOptionMenu = new OptionMenu(doubleBurgerB);

        var pizzaOptMenu = new OptionMenu(pizzaOptionA);
        var pizzaOptMenu2 = new OptionMenu(pizzaOptionB);

        // product menu
        var burgerAMenu = new ProductMenu(burgerA)
                .addOption("1", singleBurgerAOptionMenu)
                .addOption("2", doubleBurgerAOptionMenu);

        var burgerBMenu = new ProductMenu(burgerB)
                .addOption("1", singleBurgerAOptionMenu)
                .addOption("2", doubleBurgerAOptionMenu);

        var pizzaAMenu = new ProductMenu(pizzaA)
                .addOption("1", pizzaOptMenu)
                .addOption("2", pizzaOptMenu2);

        // category menu
        var subMenu1 = new CategoryMenu("burger", "test")
                .addMenu("1", burgerAMenu)
                .addMenu("2", burgerBMenu);

        var subMenu2 = new CategoryMenu("pizza", "test")
                .addMenu("1", pizzaAMenu);

        // order menu
        var orderMenu = new CommandOrderMenu("order", "장바구니 주문");
        var cancelMenu = new CommandCancelMenu("cancel", "취소");

        main = HomeMenu.single()
                .addMenu("category1", "1", subMenu1)
                .addMenu("category1", "2", subMenu2)
                .addMenu("order", "3", orderMenu)
                .addMenu("order", "4", cancelMenu)
        ;
    }
}