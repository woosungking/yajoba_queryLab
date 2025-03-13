package com.java.yajoba_querylab.domain.Image.entity;

import com.java.yajoba_querylab.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "images")
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(length = 100000)
    private String url;


    @Builder
    private Image(Product product, String url) {
        this.product = product;
        this.url = url;
    }
}

