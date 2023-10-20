package com.example.menu.template;

public abstract class DefaultMenu implements Menu {

    private final String name;
    private final String description;

    protected DefaultMenu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String description() {
        return description;
    }

    public String name() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
