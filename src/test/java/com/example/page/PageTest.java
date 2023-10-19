package com.example.page;

import com.example.domain.*;
import com.example.domain.menu.*;
import com.example.domain.product.Option;
import com.example.domain.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTest {

    @DisplayName("메인 페이지 랜더링")
    @Test
    public void render() {
        //given
        var mainMenu = MainMenu.single
                .addMenu("c1",
                        new CategoryMenu("test", "hello"),
                        new CategoryMenu("test", "hello")
                )
                .addMenu("c2",
                        new CategoryMenu("hello", "test"),
                        new CategoryMenu("cat", "cat")
                );
        MainPage mainPage = new MainPage(mainMenu);
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
        var category = new CategoryMenu("burgers", "설명")
                .addMenu(
                        new ProductMenu(new Product("cheese burger", "cheese", 1000), "1"),
                        new ProductMenu( new Product("normal burger", "normal", 2000), "2" )
                );
        var page = new ProductListPage(category);
        //when
        var render = page.render();
        //then
        System.out.println(render);
        assertTrue(render.contains("[ burgers MENU ]\n" +
                                   "1. cheese burger |       1000원 | cheese\n" +
                                   "2. normal burger |       2000원 | normal"));
    }

    @DisplayName("상품 옵션 선택 페이지")
    @Test
    public void renderProductOption() {
        //given
        var product = new Product("cheese burger", "good", 10000);
        var productMenu = new ProductMenu(product)
                .addOption(
                        new OptionMenu(new Option("Single", 0, product)),
                        new OptionMenu(new Option("Double", 1000, product))
                );
        var page = new ProductOptionPage(productMenu);
        //when
        var render = page.render();
        //then
        System.out.println(render);
        assertTrue(render.contains("\"cheese burger |      10000원 | good\"\n" +
                                   "위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n" +
                                   "1. Single(10000원)     2. Double(11000원)"));
    }

    @DisplayName("상품 구매 페이지 렌더링")
    @Test
    public void renderProductProcess() {
        //given
        var product = new Product("cheese burger", "good", 9000);
        var option = new Option("Double", 1000, product);

        var page = new ProductPurchasePage(option);
        //when
        var render = page.render();
        //then
        System.out.println(render);
        assertTrue(render.contains("\"cheese burger(Double) |      10000원 | good\"\n" +
                                   "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                                   "1. 확인     2. 취소"));
    }

    @DisplayName("주문서 출력 페이지")
    @Test
    public void renderOrder() {
        //given
        var product1 = new Product("햄버거", "test", 1000);
        var product2 = new Product("샌드위치", "test", 200);

        var cart = new Cart()
                .addOrder(new Order(product1, 2))
                .addOrder(new Order(product2, 3));

        var page = new CommandOrderPage(cart);
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }

    @DisplayName("주문 완료 페이지")
    @Test
    public void renderOrderComplete() {
        //given
        var waitingNumber = 11;
        var page = new CommandOrderAcceptPage(waitingNumber);
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }

    @DisplayName("주문 취소 페이지")
    @Test
    public void renderCancelPage() {
        //given
        var page = new CommandCancelPage();
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }

    @DisplayName("주문 취소 결과 페이지")
    @Test
    public void renderCancelAcceptPage() {
        //given
        var page = new CommandCancelAcceptPage();
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }

    @DisplayName("상품 구매 확정 페이지")
    @Test
    public void renderProductPurchaseAccept() {
        //given
        var productName = "test";
        var page = new ProductPurchaseAcceptPage(productName);
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }

    @DisplayName("총 판매 금액 페이지")
    @Test
    public void renderTotalSales() {
        //given
        var totalSales = 10000;
        var page = new AdminTotalSalesPage(totalSales);
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }

    @DisplayName("총 판매상품 목록 현황 페이지")
    @Test
    public void renderTotalSalesListPage() {
        //given
        var product1 = new Product("햄버거", "test", 1000);
        var order = new Order(product1, 2);

        var history = new SaleHistory();
        history.sale(order.product(), order.count());

        var page = new AdminSalesListPage(history);
        //when
        var render = page.render();
        //then
        System.out.println(render);
    }
}
