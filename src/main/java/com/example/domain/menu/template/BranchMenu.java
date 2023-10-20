package com.example.domain.menu.template;

import com.example.page.Page;
import com.example.state.State;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BranchMenu extends DefaultMenu implements Menu {
    protected final Map<String, Menu> commandMap = new LinkedHashMap<>();

    public BranchMenu(String name, String description) {
        super(name, description);
    }

    public void addMenu(String command, Menu menu) {
        commandMap.put(command, menu);
    }

    @Override
    public Page process(String command, State state) {
        if (!commandMap.containsKey(command)) throw new IllegalArgumentException();
        state.menu = commandMap.get(command);
        return state.page();
    }
}
