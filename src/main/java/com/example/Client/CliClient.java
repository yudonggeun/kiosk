package com.example.Client;

import com.example.domain.Store;
import com.example.domain.menu.template.Menu;
import com.example.state.State;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliClient implements Closeable, Client{

    private final BufferedReader br;
    private final State state;
    private final Store store;

    public CliClient() {
        br = new BufferedReader(new InputStreamReader(System.in));
        store = new Store();
        state = State.create(store);
    }

    public void run() throws IOException {
        System.out.println("프로그램을 시작합니다...");
        System.out.println("-1 입력시 종료합니다.\n");

        var command = "";

        System.out.println(store.homePage(this));
        while (!(command = br.readLine()).equals("-1")) {
            var page = store.request(command, this);
            System.out.println(page);

            store.buffering(this);

            if(state.isRedirect()){
                System.out.println(store.homePage(this));
            }
        }
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setMenu(Menu menu) {
        state.menu = menu;
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}
