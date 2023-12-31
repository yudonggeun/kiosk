package com.example.menu.factory;

import com.example.menu.template.Menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CategoryMenuFactory {

    private final String categoryName;

    private final Map<Menu, List<String>> categories = new LinkedHashMap<>();

    public static CategoryMenuFactory of(String categoryName){
        return new CategoryMenuFactory(categoryName);
    }
    private CategoryMenuFactory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Map<Menu, List<String>> getCategories() {
        return categories;
    }

    public CategoryMenuFactory category(Menu menu, String... commands){
        for (String command : commands) {
            categories.putIfAbsent(menu, new ArrayList<>());
            categories.get(menu).add(command);
        }
        return this;
    }
}
