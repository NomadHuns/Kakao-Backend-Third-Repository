package com.example.kakaoshop.product.response;

import com.example.kakaoshop.product.Product;
import lombok.*;

@Getter @Setter
public class ProductRespFindAllDTO {

    private int id;
    private String productName;
    private String description;
    private String image;
    private int price;

    @Builder
    public ProductRespFindAllDTO(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
    }
}