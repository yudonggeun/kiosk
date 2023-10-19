package com.example.domain.menu;

import com.example.service.Handler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private final String name;
    private final String description;
    protected final Map<String, Menu> commandMap = new LinkedHashMap<>();
    protected final Map<String, Handler> handlerMap = new HashMap<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String description() {
        return description;
    }

    public String name() {
        return name;
    }

    public Menu find(String command) {
        if (!commandMap.containsKey(command)) return this;
        return commandMap.get(command);
    }

    public Menu addMenu(String command, Menu menu) {
        commandMap.put(command, menu);
        return this;
    }

    public Menu addMenu(Menu menu, Handler handler, String command){
        addMenu(command, menu);
        handlerMap.put(command, handler);
        return this;
    }

    public Menu addMenu(Menu menu, Handler handler, String command, String... commands) {
        addMenu(menu, handler, command);
        for (var c : commands) {
            addMenu(menu, handler, c);
        }
        return this;
    }
}
