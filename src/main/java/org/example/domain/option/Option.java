package org.example.domain.option;

import org.example.domain.Menu;

public abstract class Option extends Menu {
    public Option(int order, String name, String description) {
        super(order, name, description);
    }

    @Override
    public String toString() {
        return String.format("%d. %-10s | %s", getOrder(), getName(), getDescription());
    }
}
