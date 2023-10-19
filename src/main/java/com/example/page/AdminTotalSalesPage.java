package com.example.page;

public class AdminTotalSalesPage implements Page {

    private final int totalSales;

    public AdminTotalSalesPage(int totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append("[ 총 판매금액 현황 ]\n")
                .append(String.format("현재까지 총 판매된 금액은 [ %d원 ]입니다.\n", totalSales))
                .append("1. 돌아가기\n");
        return sb.toString();
    }
}
