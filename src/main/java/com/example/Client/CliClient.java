package com.example.Client;

import com.example.state.State;
import com.example.store.BurgerKing;
import com.example.store.Store;

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
        store = new BurgerKing();
        state = State.create(store.main);
    }

    public void run() throws IOException {
        System.out.println("프로그램을 시작합니다...");
        System.out.println("-1 입력시 종료합니다.\n");

        var command = "";

        System.out.println(store.homePage(state));
        while (!(command = br.readLine()).equals("-1")) {
            var page = store.request(command,state);
            System.out.println(page);

            store.buffering(state);

            if(state.isRedirect()){
                System.out.println(store.reload(state));
            }
        }
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}
