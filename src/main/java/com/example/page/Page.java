package com.example.page;

public interface Page {

    String render();
    String href();
    void setOrder(int order);
}
