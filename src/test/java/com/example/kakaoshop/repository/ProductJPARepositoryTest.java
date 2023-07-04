package com.example.kakaoshop.repository;

import com.example.kakaoshop.product.Product;
import com.example.kakaoshop.product.ProductJPARepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductJPARepositoryTest {

    @Autowired
    private ProductJPARepository productJPARepository;

    @Test
    void findAll() {

        // when
        List<Product> productList = productJPARepository.findAll();

        // verify
        Assertions.assertNotEquals(productList.size(), 0);

        Product product = productList.get(0);
        Assertions.assertEquals(product.getId(), 1);
        Assertions.assertEquals(product.getProductName(), "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전");
        Assertions.assertEquals(product.getImage(), "/images/1.jpg");
        Assertions.assertEquals(product.getPrice(), 1000);

        product = productList.get(1);
        Assertions.assertEquals(product.getId(), 2);
        Assertions.assertEquals(product.getProductName(), "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율");
        Assertions.assertEquals(product.getImage(), "/images/2.jpg");
        Assertions.assertEquals(product.getPrice(), 2000);
    }

}
