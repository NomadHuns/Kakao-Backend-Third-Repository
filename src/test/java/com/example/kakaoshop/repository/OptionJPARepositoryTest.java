package com.example.kakaoshop.repository;

import com.example.kakaoshop.product.Product;
import com.example.kakaoshop.product.option.Option;
import com.example.kakaoshop.product.option.OptionJPARepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OptionJPARepositoryTest {
    @Autowired
    private OptionJPARepository optionJPARepository;

    @Test
    void findByProductId_test() {
        // given
        int productId = 1;

        // when
        List<Option> optionList = optionJPARepository.findByProductId(productId);

        // verify
        Assertions.assertNotEquals(optionList.size(), 0);

        Option option = optionList.get(0);
        Assertions.assertEquals(option.getId(), 1);
        Assertions.assertEquals(option.getOptionName(), "01. 슬라이딩 지퍼백 크리스마스에디션 4종");
        Assertions.assertEquals(option.getPrice(), 10000);
        Assertions.assertEquals(option.getProduct().getId(), 1);
        Assertions.assertEquals(option.getProduct().getProductName(), "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전");
        Assertions.assertEquals(option.getProduct().getImage(), "/images/1.jpg");
        Assertions.assertEquals(option.getProduct().getPrice(), 1000);

        option = optionList.get(1);
        Assertions.assertEquals(option.getId(), 2);
        Assertions.assertEquals(option.getOptionName(), "02. 슬라이딩 지퍼백 플라워에디션 5종");
        Assertions.assertEquals(option.getPrice(), 10900);
        Assertions.assertEquals(option.getProduct().getId(), 1);
        Assertions.assertEquals(option.getProduct().getProductName(), "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전");
        Assertions.assertEquals(option.getProduct().getImage(), "/images/1.jpg");
        Assertions.assertEquals(option.getProduct().getPrice(), 1000);
    }

}
