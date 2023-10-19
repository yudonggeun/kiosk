package com.example.Client;

import com.example.domain.Store;
import com.example.state.State;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliClient implements Closeable, Client{

    private final BufferedReader br;
    private State state;

    public CliClient() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException, InterruptedException {
        System.out.println("프로그램을 시작합니다...");
        System.out.println("-1 입력시 종료합니다.\n");

        var command = "";
        System.out.println(Store.store.mainPage(this));
        while (!(command = br.readLine()).equals("-1")) {
            var page = Store.store.request(command, this);
            System.out.println(page);

            if(state.isWait()){
                Thread.sleep(3000);
                System.out.println(Store.store.mainPage(this));
                state.setWait(false);
            }
            if(state.needMain()){
                System.out.println(Store.store.mainPage(this));
                state.setNeedMain(false);
            }
        }
    }

    @Override
    public State getState() {
        if(state == null) state = State.create();
        return state;
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}
