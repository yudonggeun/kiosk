package com.example.page;

import com.example.Property;
import com.example.domain.menu.MainMenu;

public class MainPage implements Page {
    private final MainMenu mainMenu;

    public MainPage(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
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
