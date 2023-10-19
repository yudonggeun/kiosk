package com.example.page;

public class CommandCancelPage implements Page {

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append("진행하던 주문을 취소하시겠습니까?\n")
                .append("1. 확인     2. 주문\n\n");
        return sb.toString();
    }
}
