package com.example.page;

public class ProductPurchaseAcceptPage implements Page {

    private final String productName;

    public ProductPurchaseAcceptPage(String productName) {
        this.productName = productName;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(productName + " 가 장바구니에 추가되었습니다.\n");
        return sb.toString();
    }
}
