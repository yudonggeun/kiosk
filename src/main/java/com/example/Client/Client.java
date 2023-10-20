package com.example.Client;


import com.example.menu.template.Menu;
import com.example.state.State;

public interface Client {
    State getState();

    void setMenu(Menu menu);
}
