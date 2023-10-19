package com.example.domain.menu;

import com.example.domain.Order;
import com.example.domain.product.Option;
import com.example.page.HomePage;
import com.example.page.Page;
import com.example.page.ProductPurchaseAcceptPage;
import com.example.page.ProductPurchasePage;
import com.example.state.State;

public class OptionMenu extends Menu {
    private final Option option;

    public OptionMenu(Option option) {
        super(option.name(), option.name());
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
        var option = ((OptionMenu) state.getMenu()).option();

        var nextMenu = HomeMenu.single();
        state.setMenu(nextMenu);

        if (command.equals("1.확인")) {
            state.addOrder(new Order(option, 1));
            state.setNeedMain(true);
            return new ProductPurchaseAcceptPage(option.name());
        } else if (command.equals("2.취소")) {
            return new HomePage(state);
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}