package org.example.domain;

import org.example.Command;

import java.util.HashMap;
import java.util.Map;

public class Control {
    private Map<String, Command> commandMap = new HashMap<>();

    public void run(String command) {
        commandMap.get(command).run();
    }

    public void put(String command, Command callBack) {
        commandMap.put(command, callBack);
    }
}
