package com.example.menu;

import com.example.menu.factory.ProductMenuFactory;
import com.example.menu.template.BranchMenu;
import com.example.menu.template.Menu;
import com.example.page.ProductListPage;
import com.example.state.State;

import java.util.LinkedHashSet;

public class CategoryMenu extends BranchMenu {
    public CategoryMenu(String name, String description) {
        super(name, description);
    }

    public Iterable<Menu> products() {
        return new LinkedHashSet<>(commandMap.values());
    }

    @Override
    public String page(State state) {
        return new ProductListPage(state).render();
    }

    public CategoryMenu addProductMenu(ProductMenuFactory factory, String... commands){
        for (String command : commands) {
            addMenu(command, factory.getProductMenu());
        }
        return this;
    }
}
