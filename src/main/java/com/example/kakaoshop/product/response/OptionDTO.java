package com.example.kakaoshop.product.response;

import lombok.*;

@Getter @Setter
public class OptionDTO {

    private int id;
    private String optionName;
    private int price;

    @Builder
    public OptionDTO(int id, String optionName, int price) {
        this.id = id;
        this.optionName = optionName;
        this.price = price;
    }
}