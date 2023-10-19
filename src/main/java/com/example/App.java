package com.example;

import com.example.Client.CliClient;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        new CliClient().run();
    }
}
