package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaleHistoryTest {

    @DisplayName("상품 판매 목록을 추가하면 list로 조회시 상품이 등록된다.")
    @Test
    public void sale() {
        //given
        var product1 = new Product("햄버거", "test", 1000);
        var order = new Order(product1, 2);

        var history = new SaleHistory();
        history.sale(order.product(), order.count());
        //when
        List<Product> products = history.products();
        //then
        assertTrue(products.contains(product1));
    }
}
