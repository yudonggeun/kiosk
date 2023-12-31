package com.example.menu;

import com.example.menu.factory.CategoryMenuFactory;
import com.example.menu.template.BranchMenu;
import com.example.menu.template.Menu;
import com.example.page.HomePage;
import com.example.state.State;

import java.util.*;

public class HomeMenu extends BranchMenu {

    private final Map<String, Set<Menu>> pageMap = new LinkedHashMap<>();

    public HomeMenu() {
        super("", "");
    }

    public HomeMenu add(String category, String command, Menu menu) {
        pageMap.putIfAbsent(category, new LinkedHashSet<>());
        pageMap.get(category).add(menu);

        addMenu(command, menu);
        return this;
    }

    public HomeMenu add(CategoryMenuFactory factory) {
        var category = factory.getCategoryName();
        for (var entry : factory.getCategories().entrySet()) {
            var menu = entry.getKey();
            for (String command : entry.getValue()) {
                add(category, command, menu);
            }
        }
        return this;
    }

    public Map<String, Set<Menu>> pageMap() {
        return pageMap;
    }

    @Override
    public String page(State state) {
        return new HomePage(state).render();
    }
}