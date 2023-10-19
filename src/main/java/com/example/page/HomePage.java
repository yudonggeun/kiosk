package com.example.page;

import com.example.config.Property;
import com.example.domain.HomeMenu;
import com.example.state.State;

public class HomePage implements Page {
    private final HomeMenu mainMenu;

    public HomePage(State state) {
        this.mainMenu = (HomeMenu) state.getMenu();
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(Property.WELCOME)
                .append(Property.MAIN_GUIDE)
                .append("\n");

        int order = 0;

        var subMenus = mainMenu.pageMap();
        for (var entry : subMenus.entrySet()) {
            var subject = entry.getKey();
            sb.append(String.format("[ %s MENU ]\n", subject));
            for (var menu : entry.getValue()) {
                sb.append(String.format("%d. %-10s | %s\n", ++order, menu.name(), menu.description()));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
