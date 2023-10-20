package com.example.menu;

import com.example.domain.Option;
import com.example.domain.Order;
import com.example.menu.template.LeafMenu;
import com.example.menu.template.Menu;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.page.ProductPurchaseAcceptPage;
import com.example.page.ProductPurchasePage;
import com.example.state.State;

public class OptionMenu extends LeafMenu {
    private final Option option;

    public OptionMenu(Option option, Menu menu) {
        super(option.name(), option.name(), menu);
        this.option = option;
    }

    public Option option() {
        return option;
    }

    @Override
    public Page page(State state) {
        return new ProductPurchasePage(state);
    }

    @Override
    public Page process(String command, State state) {
        var option = ((OptionMenu) state.menu).option();

        if (command.equals("1.확인") || command.equals("1")) {
            state.addOrder(new Order(option, 1));
            state.menu = nextMenu;
            state.redirect();
            return new ProductPurchaseAcceptPage(option.name());
        } else if (command.equals("2.취소") || command.equals("2")) {
            state.menu = nextMenu;
            return new HomePage(state);
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}