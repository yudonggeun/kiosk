package com.example.page;

import com.example.domain.menu.OptionMenu;
import com.example.domain.product.Product;
import com.example.state.State;

public class ProductPurchasePage implements Page {
    private final Product product;

    public ProductPurchasePage(State state) {
        this.product = ((OptionMenu) state.getMenu()).option();
    }

    @Override
    public String render() {
        return String.format("\"%-10s | %10d원 | %s\"\n", product.name(), product.price(), product.description()) +
               "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
               "1. 확인     2. 취소";
    }
}
