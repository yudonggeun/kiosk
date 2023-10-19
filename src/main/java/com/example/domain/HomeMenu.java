package com.example.domain;

import com.example.domain.menu.Menu;
import com.example.domain.factory.CategoryMenuFactory;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.state.State;

import java.util.*;

public class HomeMenu extends Menu {

    private final Map<String, Set<Menu>> pageMap = new LinkedHashMap<>();

    public static HomeMenu single = new HomeMenu();

    public static HomeMenu single() {
        if (single == null) single = new HomeMenu();
        return single;
    }

    private HomeMenu() {
        super("", "");
    }

    public HomeMenu addMenu(String category, String command, Menu menu) {
        pageMap.putIfAbsent(category, new LinkedHashSet<>());
        pageMap.get(category).add(menu);

        addMenu(command, menu);
        return this;
    }

    public HomeMenu addMenu(CategoryMenuFactory factory) {
        var category = factory.getCategoryName();
        for (var entry : factory.getCategories().entrySet()) {
            Menu menu = entry.getKey();
            for (String command : entry.getValue()) {
                addMenu(category, command, menu);
            }
        }
        return this;
    }

    public Map<String, Set<Menu>> pageMap() {
        return pageMap;
    }

    @Override
    public Page page(State state) {
        return new HomePage(state);
    }
}