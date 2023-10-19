package com.example.service;

import com.example.domain.Cart;
import com.example.domain.Order;
import com.example.domain.Store;
import com.example.domain.menu.*;
import com.example.page.*;
import com.example.state.State;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private Map<Object, Handler> mapping = new HashMap<>();

    public Manager() {
        mapping.put(MainMenu.class, (menu, command, state) -> {
            Page result = new MainPage((MainMenu) menu);

            var subMenu = menu.find(command);
            state.setMenu(subMenu);

            if (subMenu instanceof CategoryMenu) result = new ProductListPage((CategoryMenu) subMenu);
            else if (subMenu instanceof CommandOrderMenu) result = new CommandOrderPage(state.getCart());
            else if (subMenu instanceof CommandCancelMenu) result = new CommandCancelPage();

            return result;
        });

        mapping.put(CategoryMenu.class, (categoryMenu, command, state) -> {
            var productMenu = (ProductMenu) categoryMenu.find(command);
            state.setMenu(productMenu);
            return new ProductOptionPage(productMenu);
        });

        mapping.put(ProductMenu.class, (menu, command, state) -> {
            var optionMenu = (OptionMenu) menu.find(command);
            state.setMenu(optionMenu);
            var option = optionMenu.option();
            return new ProductPurchasePage(option);
        });

        mapping.put(OptionMenu.class, (menu, command, state) -> {
            if (command.equals("1.확인")) {
                var option = ((OptionMenu) menu).option();
                state.addOrder(new Order(option, 1));
                state.setMenu(MainMenu.single());
                state.setNeedMain(true);
                return new ProductPurchaseAcceptPage(option.name());
            } else if (command.equals("2.취소")) {
                state.setMenu(MainMenu.single());
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
            return new MainPage(Store.main);
        });

        mapping.put(CommandOrderMenu.class, (menu, command, state) -> {
            if (command.equals("1.주문")) {
                Cart cart = state.getCart();
                cart.getOrders().forEach((product, count) -> {
                    Store.record.sale(product, count);
                });
                cart.clear();
                state.setWait(true);
                state.setMenu(MainMenu.single());
                return new CommandOrderAcceptPage(OrderService.waiting());
            } else if (command.equals("2.메뉴판")) {
                state.setMenu(MainMenu.single());
                return new MainPage(Store.main);
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
        });

        mapping.put(CommandCancelMenu.class, (menu, command, state) -> {
            if (command.equals("1.확인")) {
                state.getCart().clear();
                state.setMenu(MainMenu.single());
                state.setNeedMain(true);
                return new CommandCancelAcceptPage();
            } else if (command.equals("2.취소")) {
                state.setMenu(MainMenu.single());
                return new MainPage(Store.main);
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
        });

        mapping.put(BackMenu.class, (menu, command, state) -> {
           if (command.equals("1.돌아가기")){
               state.setMenu(MainMenu.single());
               return new MainPage(Store.main);
           }
            throw new IllegalArgumentException("잘못된 입력");
        });
    }

    public Page handle(Menu menu, String command, State state) {
        if(command.equals("0")){
            return getTotalSalePrice(menu, state);
        } else if(command.equals("=")){
            return getTotalSaleList(menu, state);
        }

        return mapping.get(menu.getClass())
                .handle(menu, command, state);
    }

    public Page getTotalSalePrice(Menu menu, State state) {
        state.setMenu(new BackMenu(menu));
        return new AdminTotalSalesPage(Store.record.totalSalePrice());
    }

    public Page getTotalSaleList(Menu menu, State state) {
        state.setMenu(new BackMenu(menu));
        return new AdminSalesListPage(Store.record);
    }
}
