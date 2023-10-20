package com.example.domain.menu.template;

import com.example.page.Page;
import com.example.state.State;

public interface Menu {
    String description();
    String name();
    Page page(State state);
    Page process(String command, State state);
}
