package com.example.kakaoshop.repository;

import com.example.kakaoshop.product.Product;
import com.example.kakaoshop.product.ProductQueryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductQueryRepositoryTest {

    @Autowired
    private ProductQueryRepository productQueryRepository;

    @Test
    void findById_test() {
        // given
        int id = 1;

        // when
        Optional<Product> productOP = productQueryRepository.findById(id);

        // verify
        Product product = productOP.get();
        Assertions.assertEquals(product.getId(), 1);
        Assertions.assertEquals(product.getProductName(), "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전");
        Assertions.assertEquals(product.getImage(), "/images/1.jpg");
        Assertions.assertEquals(product.getPrice(), 1000);
    }

    @Test
    void updateProductName_test() {
        // given
        int id = 1;
        String productName = "수정 완료!";

        // when
        productQueryRepository.updateProductName(id, productName);

        // verify
        Product productPS = productQueryRepository.findById(id).get();
        Assertions.assertEquals(productPS.getId(), 1);
        Assertions.assertEquals(productPS.getProductName(), productName);
        Assertions.assertEquals(productPS.getImage(), "/images/1.jpg");
        Assertions.assertEquals(productPS.getPrice(), 1000);

    }

}
