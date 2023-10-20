package com.example.service;

import com.example.menu.BackMenu;
import com.example.page.AdminSalesListPage;
import com.example.page.AdminTotalSalesPage;
import com.example.page.Page;
import com.example.state.State;

public class Manager {

    public Page handle(String command, State state) {
        if (command.equals("0")) {
            return getTotalSalePrice(state);
        } else if (command.equals(".")) {
            return getTotalSaleList(state);
        }
        return state.menu.process(command, state);
    }

    public Page getTotalSalePrice(State state) {
        state.menu = new BackMenu(state.menu);
        return new AdminTotalSalesPage();
    }

    public Page getTotalSaleList(State state) {
        state.menu = new BackMenu(state.menu);
        return new AdminSalesListPage();
    }
}
