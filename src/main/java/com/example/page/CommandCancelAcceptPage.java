package com.example.page;

public class CommandCancelAcceptPage implements Page {
    @Override
    public String render() {
        var sb = new StringBuilder()
                .append("진행하던 주문이 취소되었습니다.\n\n");
        return sb.toString();
    }
}
