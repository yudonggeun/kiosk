package com.example.page;

public class ErrorPage implements Page{
    @Override
    public String render() {
        return "입력이 옳바르지 않습니다. 다시 입력해주세요!!";
    }
}
