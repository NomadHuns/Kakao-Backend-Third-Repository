package com.example.kakaoshop.product.response;

import lombok.*;

import java.util.List;

@Getter @Setter
public class ProductRespFindByIdDTO {

    private int id;
    private String productName;
    private String description;
    private String image;
    private int price;
    private int starCount; // 0~5
    private List<OptionDTO> options;

    @Builder
    public ProductRespFindByIdDTO(int id, String productName, String description, String image, int price, int starCount, List<OptionDTO> options) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.image = image;
        this.price = price;
        this.starCount = starCount;
        this.options = options;
    }
}