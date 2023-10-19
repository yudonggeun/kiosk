package com.example.domain.menu;

import com.example.domain.menu.factory.ProductMenuFactory;
import com.example.page.Page;
import com.example.page.ProductListPage;
import com.example.state.State;

import java.util.LinkedHashSet;

public class CategoryMenu extends Menu {
    public CategoryMenu(String name, String description) {
        super(name, description);
    }

    public Iterable<Menu> products() {
        return new LinkedHashSet<>(commandMap.values());
    }

    @Override
    public Page page(State state) {
        return new ProductListPage(state);
    }

    public CategoryMenu addProductMenu(ProductMenuFactory factory, String... commands){
        for (String command : commands) {
            addMenu(command, factory.getProductMenu());
        }
        return this;
    }
}
