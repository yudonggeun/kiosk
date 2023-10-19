package com.example.domain.menu;

public class CategoryMenu extends Menu {
    public CategoryMenu(String name, String description) {
        super(name, description);
    }

    public Iterable<Menu> products() {
        return commandMap.values();
    }
}
