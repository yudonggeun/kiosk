package com.example.domain.menu;

import com.example.page.CommandCancelAcceptPage;
import com.example.page.CommandCancelPage;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.state.State;

public class CommandCancelMenu extends Menu {
    public CommandCancelMenu(String name, String description) {
        super(description, name);
    }

    @Override
    public Page page(State state) {
        return new CommandCancelPage();
    }

    @Override
    public Page process(String command, State state) {
        if (command.equals("1.확인")) {
            state.getCart().clear();
            state.setMenu(HomeMenu.single());
            state.setNeedMain(true);
            return new CommandCancelAcceptPage();
        } else if (command.equals("2.취소")) {
            state.setMenu(HomeMenu.single());
            return new HomePage(state);
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}