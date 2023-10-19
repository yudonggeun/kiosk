package com.example.domain;

public class Menu {
    private String description;

    private String name;

    public Menu(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public String description() {
        return description;
    }

    public String name() {
        return name;
    }
}
