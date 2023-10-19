package com.example.page;

import com.example.domain.menu.ProductMenu;
import com.example.domain.Option;
import com.example.domain.Product;
import com.example.state.State;

import java.util.Set;

public class ProductOptionPage implements Page {

    private final Product product;
    private final Set<Option> options;

    public ProductOptionPage(State state) {
        var menu = (ProductMenu) state.getMenu();
        this.product = menu.getProduct();
        this.options = menu.getOptions();
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(String.format("\"%-10s | %10d원 | %s\"\n", product.name(), product.price(), product.description()))
                .append("위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n")
                ;

        int order = 0;
        for (var option : options) {
            sb.append(String.format("%d. %s(%d원)     ", ++order, option.optionName(), option.price()));
        }
        sb.append("\n");

        return sb.toString();
    }
}
