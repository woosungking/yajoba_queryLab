package com.java.yajoba_querylab.domain.review.entity;

import com.java.yajoba_querylab.domain.product.entity.Product;
import com.java.yajoba_querylab.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Getter
@NoArgsConstructor
public class Review{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // 상품과 다대일 관계 설정
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)  // 사용자와 다대일 관계 설정
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 500)
    private String content;

    @Column(nullable = false)
    private int rating;
    @Builder
    public Review(Product product, User user, String content, int rating) {
        this.product = product;
        this.user = user;
        this.content = content;
    }
}
