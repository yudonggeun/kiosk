package com.example.page;

import com.example.Property;
import com.example.domain.Menu;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainPage implements Page {

    private final Map<String, List<Menu>> subMenus = new LinkedHashMap<>();

    public MainPage subMenu(String subject, Menu... pages) {
        subMenus.put(subject, Arrays.stream(pages).toList());
        return this;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(Property.WELCOME)
                .append(Property.MAIN_GUIDE)
                .append("\n");

        int order = 0;
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
