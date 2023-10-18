package com.example.domain;

import java.util.*;

public class MainMenu extends Menu {

    private Map<String, List<Menu>> menuMap = new LinkedHashMap<>();
    private Map<Integer, Menu> orderMap = new TreeMap<>();
    private Map<String, Menu> nameMap = new HashMap<>();

    private int count = 0;

    public MainMenu() {
        super("", "");
    }

    public MainMenu addMenu(String category, Menu... menus) {
        menuMap.put(category, Arrays.stream(menus).toList());
        for (Menu menu : menus) {
            orderMap.put(++count, menu);
            nameMap.put(menu.getName(), menu);
        }
        return this;
    }

    public Map<String, List<Menu>> menuMap(){
        return menuMap;
    }
}