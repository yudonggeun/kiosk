package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @DisplayName("장바구니에 상품을 넣는다.")
    @Test
    public void addProductToCart() {
        //given
        var product1 = new Product("햄버거", "test", 1000);
        var cart = new Cart();
        cart.addOrder(new Order(product1, 1));
        //when
        Map<Product, Integer> productMap = cart.listMap();
        //then
        assertEquals(productMap.get(product1), 1);
    }

    @DisplayName("장바구니의 상품들의 가격의 총합 계산")
    @Test
    public void totalPrice() {
        // given
        var product1 = new Product("햄버거", "test", 1000);
        var product2 = new Product("샌드위치", "test", 200);
        var cart = new Cart();
        cart.addOrder(new Order(product1, 2));
        cart.addOrder(new Order(product2, 3));
        //when
        int totalPrice = cart.totalPrice();
        //then
        assertEquals(totalPrice, 2600);
    }
}