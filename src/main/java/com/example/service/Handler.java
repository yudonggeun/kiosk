package com.example.service;

import com.example.page.Page;
import com.example.state.State;

public interface Handler {
    Page handle(String command, State state);
}
