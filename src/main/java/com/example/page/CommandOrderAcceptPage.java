package com.example.page;

import com.example.service.OrderService;

public class CommandOrderAcceptPage implements Page {

    private final int waitingNumber;

    public CommandOrderAcceptPage() {

        this.waitingNumber = OrderService.waiting();
    }

    @Override
    public String render() {
        return "주문이 완료되었습니다!\n\n" +
               String.format("대기번호는 [ %d ] 번 입니다.\n", waitingNumber) +
               "(3초후 메뉴판으로 돌아갑니다.)\n\n";
    }
}
