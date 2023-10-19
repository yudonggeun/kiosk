package com.example.page;

import com.example.response.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductOptionPage implements Page {

    private final ProductResponse product;
    private final List<OptionDto> options = new ArrayList<>();

    public ProductOptionPage(ProductResponse product) {
        this.product = product;
    }

    public ProductOptionPage option(String name, int additionalFee){
        options.add(new OptionDto(name, additionalFee));
        return this;
    }

    @Override
    public String render() {
        var sb = new StringBuilder()
                .append(String.format("\"%-10s | %10d원 | %s\"\n", product.name(), product.price(), product.description()))
                .append("위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n")
                ;

        int order = 0;
        for (OptionDto option : options) {
            sb.append(String.format("%d. %s(%d원)     ", ++order, option.name, product.price() + option.additionalFee));
        }
        sb.append("\n");

        return sb.toString();
    }

    class OptionDto{
        private String name;

        private int additionalFee;

        public OptionDto(String name, int additionalFee) {
            this.name = name;
            this.additionalFee = additionalFee;
        }
    }

}
