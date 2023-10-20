package com.example.menu.template;

import com.example.page.ErrorPage;
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
    public String process(String command, State state) {
        if (!commandMap.containsKey(command)) {
            state.redirect();
            return new ErrorPage().render();
        }
        state.menu = commandMap.get(command);
        return state.page();
    }
}
