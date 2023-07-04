package com.example.kakaoshop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductQueryRepository extends JpaRepository<Product, Integer> {

    // Read: 특정 id에 해당하는 Product 찾기
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> findById(@Param("id") Integer id);

    // Update: 특정 id의 Product의 description을 변경하는 쿼리
    @Modifying
    @Query("UPDATE Product p SET p.productName = :productName WHERE p.id = :id")
    void updateProductName(@Param("id") Integer id, @Param("productName") String productName);

}
