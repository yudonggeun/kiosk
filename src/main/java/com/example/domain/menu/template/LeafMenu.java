package com.example.domain.menu.template;

public abstract class LeafMenu extends DefaultMenu implements Menu {
    protected final Menu nextMenu;
    protected LeafMenu(String name, String description, Menu nextMenu) {
        super(name, description);
        this.nextMenu = nextMenu;
    }
}
