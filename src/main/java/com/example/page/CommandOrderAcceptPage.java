package com.example.page;

public class CommandOrderAcceptPage implements Page {

    private final int waitingNumber;

    public CommandOrderAcceptPage(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append("주문이 완료되었습니다!\n\n")
                .append(String.format("대기번호는 [ %d ] 번 입니다.\n", waitingNumber))
                .append("(3초후 메뉴판으로 돌아갑니다.)\n\n");
        return sb.toString();
    }
}
