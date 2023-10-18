package com.example.page;

import com.example.response.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTest {
    @DisplayName("상품 페이지 랜더링")
    @Test
    public void render() {
        //given
        var page = new ProductsPage("burgers")
                .addProduct(
                        new ProductResponse("cheese burger", "cheese", 1000),
                        new ProductResponse("normal burger", "normal", 2000)
                );
        //when
        var render = page.render();
        //then
        System.out.println(render);
        assertTrue(render.contains("[ burgers MENU ]\n" +
                                   "1. cheese burger |       1000원 | cheese\n" +
                                   "2. normal burger |       2000원 | normal"));
    }
}
