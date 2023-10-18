package org.example;

import org.example.domain.State;
import org.example.domain.menu.MainPage;
import org.example.domain.menu.MenuList;
import org.example.domain.option.Cancel;
import org.example.domain.option.Order;
import org.example.domain.product.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private final String storeName;
    private final String welcome;
    private final String guide;

    public App(String storeName, String welcome, String guide) {
        this.storeName = storeName;
        this.welcome = welcome;
        this.guide = guide;
    }

    public void start() {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("개업 준비 중...");
            System.out.println("패업을 원하면 -1을 입력하세요.");
            System.out.println("숫자만 입력해야 합니다.");
            System.out.println("오픈!!!\n");
            init();

            manager.print();
            String input;

            while (!(input = br.readLine()).equals("-1")) {
                manager.run(input);
                manager.print();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("패업합니다.");
        }
    }


    private void init() {
        // init menu
        var main = new MainPage("main", "main");

        main.add(
                new MenuList("sub menu1", "sub 1", 1)
                        .add(
                                new MenuList("burgers", "버거", 1).add(
                                        new Product("product1", 1000, "product1", 1)
                                                .onPurchase(main)
                                                .onCancel(main),
                                        new Product("product2", 2000, "product2", 2)
                                                .onPurchase(main)
                                                .onCancel(main)
                                )
                        ),
                new MenuList("sub menu1", "sub 1", 2)
                        .add(
                                new MenuList("drinks", "음료", 2).add(
                                        new Product("product1", 1000, "product1", 1)
                                                .onPurchase(main)
                                                .onCancel(main),
                                        new Product("product2", 2000, "product2", 2)
                                                .onPurchase(main)
                                                .onCancel(main)
                                )
                        ),
                new MenuList("option", "옵션들", 3)
                        .add(
                                new Order(4)
                                        .onPay(main)
                                        .onMenu(main)
                                ,
                                new Cancel(5)
                                        .onClear(main)
                                        .onMenu(main)
                        )
        );
        // init manager
        manager = new Manager(main);
    }

    private Manager manager;

    public static void main(String[] args) {
        var storeName = "해태";
        var welcomeSentence = "환영합니다.";
        var guideSentence = "아래 상품 메뉴판을 보시고 상품을 골라 입력해주세요.";

        new App(storeName, welcomeSentence, guideSentence)
                .start();
    }
}