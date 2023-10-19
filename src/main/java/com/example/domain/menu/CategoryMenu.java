package com.example.domain.menu;

public class CategoryMenu extends ParentMenu<ProductMenu> {
    public CategoryMenu(String name, String description, String... commands) {
        super(name, description, commands);
    }

    public CategoryMenu addMenu(ProductMenu... menu) {
        for (var productMenu : menu) {
            addMenu(productMenu);
        }
        return this;
    }

    public Iterable<Menu> products(){
        var menuList = menuList();
        return menuList;
    }
}
