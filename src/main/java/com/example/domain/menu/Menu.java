package com.example.domain.menu;

public class Menu {
    private String description;
    private String name;
    private String[] command;

    public Menu(String description, String name, String... commands) {
        this.description = description;
        this.command = commands;
        this.name = name;
    }

    public String description() {
        return description;
    }

    public String name() {
        return name;
    }

    public Menu setCommand(String... command) {
        this.command = command;
        return this;
    }

    protected String[] commands() {
        return command;
    }

    public Menu find(String command) {
        return null;
    }
}
