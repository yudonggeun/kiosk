package com.example.page;

public class CommandCancelPage implements Page {
    @Override
    public String render() {
        return """
                진행하던 주문을 취소하시겠습니까?
                1. 확인     2. 취소
                """;
    }
}
