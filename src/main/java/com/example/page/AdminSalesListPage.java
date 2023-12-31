package com.example.page;

import com.example.domain.SaleHistory;
import com.example.store.Store;

public class AdminSalesListPage implements Page {

    private final SaleHistory saleHistory;

    public AdminSalesListPage() {
        this.saleHistory = Store.record;
    }
    @Override
    public String render() {
        var sb = new StringBuilder()
                .append("[ 총 판매 상품 목록 현황 ]\n")
                .append("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");

        saleHistory.products()
                .forEach(product -> sb.append(String.format("- %-10s | %10d원\n", product.name(), product.price())));

        sb.append("\n")
          .append("1. 돌아가기\n");

        return sb.toString();
    }
}
