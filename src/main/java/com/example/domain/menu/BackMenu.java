package com.example.domain.menu;

import com.example.page.Page;
import com.example.state.State;

public class BackMenu extends Menu {
    private final Menu preMenu;
    public BackMenu(Menu perMenu) {
        super("","");
        this.preMenu = perMenu;
    }

    @Override
    public Page page(State state) {
        return preMenu.page(state);
    }

    @Override
    public Page process(String command, State state) {
        if(command.equals("1.돌아가기")){
            state.setMenu(preMenu);
            return  state.page();
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}
