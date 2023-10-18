package com.example.page;

import com.example.Property;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainPage implements Page {

    private final Map<String, List<Page>> subPages = new LinkedHashMap<>();
    private int size = 0;

    public MainPage subPage(String subject, Page... pages) {
        for (Page page : pages) page.setOrder(++size);
        subPages.put(subject, Arrays.stream(pages).toList());
        return this;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(Property.WELCOME)
                .append(Property.MAIN_GUIDE)
                .append("\n");

        subPages.forEach((name, menus) -> {
            sb.append(String.format("[ %s MENU ]\n", name));
            for (Page page : menus) {
                sb.append(page.href());
            }
            sb.append("\n");
        });

        return sb.toString();
    }

    @Override
    public String href() {
        return "";
    }

    @Override
    public void setOrder(int order) {

    }

}
