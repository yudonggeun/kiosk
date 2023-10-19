package com.example.domain.menu;

public class BackMenu extends Menu {
    private final Menu preMenu;
    public BackMenu(Menu perMenu) {
        super("","");
        this.preMenu = perMenu;
    }

    public Menu preMenu(){
        return preMenu;
    }
}
