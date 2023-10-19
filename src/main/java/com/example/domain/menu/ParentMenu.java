package com.example.domain.menu;

import java.util.*;

public class ParentMenu<T extends Menu> extends Menu{
    private Map<String, T> commandMap = new LinkedHashMap<>();
    private int count = 0;

    public ParentMenu(String name, String description, String... commands) {
        super(description, name, commands);
    }

    protected void addMenu(T menu){
        count++;
        for (String command : menu.commands()) {
            commandMap.put(command, menu);
        }
    }

    public Menu find(String command){
        if(!commandMap.containsKey(command)) return this;
        return commandMap.get(command);
    }
    protected Iterable<Menu> menuList() {
        return (Iterable<Menu>) commandMap.values();
    }
}
