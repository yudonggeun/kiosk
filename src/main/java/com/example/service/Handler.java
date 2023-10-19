package com.example.service;

import com.example.domain.menu.Menu;
import com.example.page.Page;
import com.example.state.State;

public interface Handler {
    Page handle(Menu menu, String command, State state);
}
