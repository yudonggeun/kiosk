package com.example.domain.menu;

import com.example.page.Page;
import com.example.state.State;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Menu {
    private final String name;
    private final String description;
    protected final Map<String, Menu> commandMap = new LinkedHashMap<>();

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

    public Menu addMenu(String command, Menu menu) {
        commandMap.put(command, menu);
        return this;
    }

    public abstract Page page(State state);

    public Page process(String command, State state) {
        if (!commandMap.containsKey(command)) throw new IllegalArgumentException();
        var nextMenu = commandMap.get(command);
        state.setMenu(nextMenu);
        return state.page();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
