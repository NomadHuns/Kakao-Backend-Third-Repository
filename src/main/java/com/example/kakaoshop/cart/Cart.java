package com.example.kakaoshop.cart;

import com.example.kakaoshop.product.option.ProductOption;
import com.example.kakaoshop.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="cart_tb",
        indexes = {
                @Index(name = "cart_user_id_idx", columnList = "user_id"),
                @Index(name = "cart_option_id_idx", columnList = "product_option_id")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_cart_option_user", columnNames = {"user_id", "product_option_id"})
        })
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductOption productOption;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @Builder
    public Cart(int id, User user, ProductOption productOption, int quantity, int price) {
        this.id = id;
        this.user = user;
        this.productOption = productOption;
        this.quantity = quantity;
        this.price = price;
    }

    // 장바구니 업데이트
    public void update(int quantity, int price){
        this.quantity = quantity;
        this.price = price;
    }
}