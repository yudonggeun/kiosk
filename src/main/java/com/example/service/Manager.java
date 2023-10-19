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

    private final Map<Object, Handler> mapping = new HashMap<>();

    public Manager() {
        mapping.put(HomeMenu.class, (command, state) -> {
            Page result = new HomePage(state);

            var subMenu = state.getMenu().find(command);
            state.setMenu(subMenu);

            if (subMenu instanceof CategoryMenu) result = new ProductListPage(state);
            else if (subMenu instanceof CommandOrderMenu) result = new CommandOrderPage(state);
            else if (subMenu instanceof CommandCancelMenu) result = new CommandCancelPage();

            return result;
        });

        mapping.put(CategoryMenu.class, (command, state) -> {
            var productMenu = (ProductMenu) state.getMenu().find(command);
            state.setMenu(productMenu);
            return new ProductOptionPage(state);
        });

        mapping.put(ProductMenu.class, (command, state) -> {
            var optionMenu = (OptionMenu) state.getMenu().find(command);
            state.setMenu(optionMenu);
            return new ProductPurchasePage(state);
        });

        mapping.put(OptionMenu.class, (command, state) -> {
            if (command.equals("1.확인")) {
                var option = ((OptionMenu) state.getMenu()).option();
                state.addOrder(new Order(option, 1));
                state.setNeedMain(true);
                state.setMenu(HomeMenu.single());
                return new ProductPurchaseAcceptPage(option.name());
            } else if (command.equals("2.취소")) {
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
            state.setMenu(HomeMenu.single());
            return new HomePage(state);
        });

        mapping.put(CommandOrderMenu.class, (command, state) -> {
            if (command.equals("1.주문")) {
                Cart cart = state.getCart();
                cart.getOrders().forEach(Store.record::sale);
                cart.clear();
                state.setWait(true);
                state.setMenu(HomeMenu.single());
                return new CommandOrderAcceptPage();
            } else if (command.equals("2.메뉴판")) {
                state.setMenu(HomeMenu.single());
                return new HomePage(state);
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
        });

        mapping.put(CommandCancelMenu.class, (command, state) -> {
            if (command.equals("1.확인")) {
                state.getCart().clear();
                state.setMenu(HomeMenu.single());
                state.setNeedMain(true);
                return new CommandCancelAcceptPage();
            } else if (command.equals("2.취소")) {
                state.setMenu(HomeMenu.single());
                return new HomePage(state);
            } else {
                throw new IllegalArgumentException("잘못된 입력");
            }
        });

        mapping.put(BackMenu.class, (command, state) -> {
            if (command.equals("1.돌아가기")) {
                state.setMenu(HomeMenu.single());
                return new HomePage(state);
            }
            throw new IllegalArgumentException("잘못된 입력");
        });
    }

    public Page handle(String command, State state) {
        var menu = state.getMenu();
        if (command.equals("0")) {
            return getTotalSalePrice(state);
        } else if (command.equals("=")) {
            return getTotalSaleList(state);
        }

        return mapping.get(menu.getClass())
                .handle(command, state);
    }

    public Page getTotalSalePrice(State state) {
        state.setMenu(new BackMenu(state.getMenu()));
        return new AdminTotalSalesPage();
    }

    public Page getTotalSaleList(State state) {
        state.setMenu(new BackMenu(state.getMenu()));
        return new AdminSalesListPage();
    }
}
