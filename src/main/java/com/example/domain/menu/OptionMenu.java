package com.example.domain.menu;

import com.example.domain.product.Option;

public class OptionMenu extends Menu {
    private final Option option;
    public OptionMenu(Option option, String... command) {
        super(option.name(), option.name(), command);
        this.option = option;
    }

    public Option option() {
        return option;
    }
}