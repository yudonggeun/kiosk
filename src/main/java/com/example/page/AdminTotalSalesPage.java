package com.example.page;

import com.example.domain.Store;
import com.example.state.State;

import static java.lang.String.*;

public class AdminTotalSalesPage implements Page {

    private final int totalSales;

    public AdminTotalSalesPage() {
        this.totalSales = Store.record.totalSalePrice();
    }

    @Override
    public String render() {
        return "[ 총 판매금액 현황 ]\n" +
               format("현재까지 총 판매된 금액은 [ %d원 ]입니다.\n", totalSales) +
               "1. 돌아가기\n";
    }
}
