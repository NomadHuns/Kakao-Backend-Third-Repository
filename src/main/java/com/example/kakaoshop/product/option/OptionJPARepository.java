package com.example.kakaoshop.product.option;

import com.example.kakaoshop.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionJPARepository extends JpaRepository<Option, Integer> {
    List<Option> findByProductId(int productId);
}
