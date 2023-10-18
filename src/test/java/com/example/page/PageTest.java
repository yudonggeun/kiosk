package com.example.page;

import com.example.response.MenuDto;
import com.example.response.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTest {

    @DisplayName("메인 페이지 랜더링")
    @Test
    public void render() {
        //given
        MainPage mainPage = new MainPage()
                .subMenu("c1",
                        new MenuDto("hello", "test"),
                        new MenuDto("hello", "test")
                )
                .subMenu("c2",
                        new MenuDto("test", "hello"),
                        new MenuDto("cat", "cat")
                );
        //when
        var page = mainPage.render();
        //then
        System.out.println(page);
        assertTrue(page.contains("[ c1 MENU ]\n" +
                                 "1. test       | hello\n" +
                                 "2. test       | hello\n" +
                                 "\n" +
                                 "[ c2 MENU ]\n" +
                                 "3. hello      | test\n" +
                                 "4. cat        | cat"));
    }

    @DisplayName("상품 페이지 랜더링")
    @Test
    public void renderProductPage() {
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

    @DisplayName("상품 구매 페이지 렌더링")
    @Test
    public void renderProductProcess() {
        //given
        var page = new ProductProcessPage(new ProductResponse("cheese burger(Single)", "good", 10000));
        //when
        var render = page.render();
        //then
        System.out.println(render);
        assertTrue(render.contains("cheese burger(Single) |      10000원 | good\n" +
                                   "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                                   "1. 확인     2. 취소"));
    }
}
