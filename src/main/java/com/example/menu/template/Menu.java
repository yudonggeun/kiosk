package com.example.menu.template;

import com.example.state.State;

public interface Menu {
    String description();
    String name();
    String page(State state);
    String process(String command, State state);
}
