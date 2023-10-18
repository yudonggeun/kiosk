package org.example.domain;

import org.example.Command;

public class Menu {
    private String name;
    private String description;
    private int order;
    protected final Control control;

    public Menu(int order, String name, String description) {
        this.order = order;
        this.name = name;
        this.description = description;
        this.control = new Control();
    }

    public Menu addListener(String command, Command callBack){
        control.put(command, callBack);
        return this;
    }

    public String getCommand(){
        return order + "." + name;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String command(){
        return String.format("%d.%s", order, name);
    }

    public void run(String command) {
        control.run(command);
    }

    public String toMenuString(){
        return String.format("%d. %-10s | %s",getOrder(), getName(), getDescription());
    }
}
