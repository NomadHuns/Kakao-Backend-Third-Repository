package com.example.kakaoshop.product;

import com.example.kakaoshop._core.utils.ApiUtils;
import com.example.kakaoshop.product.response.ProductRespFindAllDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductJPARepository productJPARepository;

    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        // 데이터베이스로부터 데이터 받아오기
        List<Product> productListPS = productJPARepository.findAll();

        List<ProductRespFindAllDTO> responseDTO = productListPS.stream().map(ProductRespFindAllDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
}
