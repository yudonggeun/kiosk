package com.example.store;

import com.example.domain.Product;
import com.example.menu.CategoryMenu;
import com.example.menu.CommandCancelMenu;
import com.example.menu.CommandOrderMenu;
import com.example.menu.factory.CategoryMenuFactory;
import com.example.menu.factory.ProductMenuFactory;

public class BurgerKing extends Store {

    public void init() {
        // product with option
        var wapper = ProductMenuFactory.of(new Product("와퍼", "불에 직접 구운 순 쇠고기 패티에 싱싱한 야채가 한가득~ 버거킹의 대표 메뉴!", 5000), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1600, "2", "세트");

        var quitroCheeseWapper = ProductMenuFactory.of(new Product("콰트로치즈와퍼", "진짜 불맛을 즐겨라, 4가지 고품격 치즈와 불에 직접 구운 와퍼 패티의 만남!", 5700), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1800, "2", "세트");

        var koreanWapper = ProductMenuFactory.of(new Product("불고기와퍼", "불에 직접 구운 순 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!", 6000), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1800, "2", "세트");

        var shrimpWapper = ProductMenuFactory.of(new Product("통새우와퍼", "불에 직접 구운 순 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!", 6000), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1800, "2", "세트");

        var cheeseWapper = ProductMenuFactory.of(new Product("치즈와퍼", "불에 직접 구운 순 쇠고기 패티가 들어가 와퍼에 고소한 치즈까지", 5700), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1700, "2", "세트");

        var monsterX = ProductMenuFactory.of(new Product("몬스터X", "불맛 가늑 순쇠고기, 치킨, 베이컨에 화끈한 디아블로 소스의 압도적인 맛", 8700), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 2000, "2", "세트");

        var quitroCheeseBurgerX = ProductMenuFactory.of(new Product("콰트로치즈와퍼X", "진짜 불맛을 즐겨라, 4가지 고품격 치즈와 불에 직접 구운 와퍼 패티의 만남!", 6900), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1800, "2", "세트");

        var shrimpWapperX = ProductMenuFactory.of(new Product("통새우와퍼X", "불에 직접 구운 순 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!", 6900), main)
                .option("단품", 0, "1", "단품")
                .option("세트", 1800, "2", "세트");

        var coke = ProductMenuFactory.of(new Product("콜라", "햄버거랑 콜라랑", 2000), main)
                .option("medium", 0, "1")
                .option("large", 500, "2");

        var orange = ProductMenuFactory.of(new Product("오랜지 주스", "맛있는 주스 ^^", 2300), main)
                .option("medium", 0, "1")
                .option("large", 500, "2");

        // category to product menu
        var wapperBurgers = new CategoryMenu("wapper", "버거킹의 다양한 와퍼들!!")
                .addProductMenu(wapper, "1", "와퍼")
                .addProductMenu(quitroCheeseWapper, "2", "과트로치즈와퍼")
                .addProductMenu(koreanWapper, "3", "불고기와퍼")
                .addProductMenu(shrimpWapper, "4", "통새우와퍼")
                .addProductMenu(cheeseWapper, "5", "치츠와퍼");

        var wapperX = new CategoryMenu("X", "거대하고 짜릿한 X 버거!!")
                .addProductMenu(monsterX, "1", "monsterX", "몬스터x", "몬스터X")
                .addProductMenu(quitroCheeseBurgerX, "2", "콰드로치즈와퍼", "콰트로", "콰드로치즈와퍼X", "콰드로치츠와퍼x")
                .addProductMenu(shrimpWapperX, "3", "통새우와퍼", "통새우와퍼X", "통새우와퍼x");

        var drink = new CategoryMenu("drink", "시원한 음료!!")
                .addProductMenu(coke, "1", "콜라", "coke")
                .addProductMenu(orange, "2", "오랜지", "오랜지 주스", "오랜지주스");
        // main to category
        main
                .add(
                        CategoryMenuFactory.of("맛있는 버거와 드링크")
                                .category(wapperBurgers, "1", "wapper", "와퍼")
                                .category(wapperX, "2", "x", "X")
                                .category(drink, "3", "drink", "음료")
                )

                .add(
                        CategoryMenuFactory.of("주문")
                                .category(new CommandOrderMenu( "주문하기", "모든 메뉴를 선택했다면 주문을 해주세요.", main), "4", "장바구니 주문")
                                .category(new CommandCancelMenu( "주문 초기화", "주문을 취소하고 싶으신가요?", main), "5", "취소")
                )
        ;
    }
}
