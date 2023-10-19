package com.example.domain.menu;

import java.util.*;

public class MainMenu extends ParentMenu<Menu>{

    private Map<String, List<Menu>> pageMap = new LinkedHashMap<>();

    public static MainMenu single = new MainMenu();

    public static MainMenu single(){
        if(single == null) single = new MainMenu();
        return single;
    }

    private MainMenu() {
        super("", "");
    }

    public MainMenu addMenu(String subject, Menu... menus) {
        for (var menu : menus) {
            addMenu(subject, menu);
        }
        return this;
    }

    private MainMenu addMenu(String category, Menu menu) {
        pageMap.putIfAbsent(category, new ArrayList<>());
        pageMap.get(category).add(menu);

        addMenu(menu);
        return this;
    }

    public Map<String, List<Menu>> pageMap() {
        return pageMap;
    }
}