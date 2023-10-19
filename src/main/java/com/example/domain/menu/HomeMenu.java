package com.example.domain.menu;

import java.util.*;

public class HomeMenu extends Menu {

    private final Map<String, List<Menu>> pageMap = new LinkedHashMap<>();

    public static HomeMenu single = new HomeMenu();

    public static HomeMenu single(){
        if(single == null) single = new HomeMenu();
        return single;
    }

    private HomeMenu() {
        super("", "");
    }

    public HomeMenu addMenu(String category, String command, Menu menu) {
        pageMap.putIfAbsent(category, new ArrayList<>());
        pageMap.get(category).add(menu);

        addMenu(command, menu);
        return this;
    }

    public Map<String, List<Menu>> pageMap() {
        return pageMap;
    }
}