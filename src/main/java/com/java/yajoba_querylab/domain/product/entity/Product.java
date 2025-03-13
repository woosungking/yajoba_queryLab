package com.java.yajoba_querylab.domain.product.entity;


import com.java.yajoba_querylab.domain.category.entity.Category;
import com.java.yajoba_querylab.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "products", indexes = @Index(name="idx_created_at",columnList = "created_at DESC"))
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // 사용자와 다대일 관계 설정
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)  // 대분류와 다대일 관계 설정
    @JoinColumn(name = "b_category_id", nullable = false) // 외래 키 이름 수정
    private Category bCategory;

    @ManyToOne(fetch = FetchType.LAZY)  // 중분류와 다대일 관계 설정
    @JoinColumn(name = "m_category_id", nullable = false) // 외래 키 이름 수정
    private Category mCategory;

    @ManyToOne(fetch = FetchType.LAZY)  // 소분류와 다대일 관계 설정
    @JoinColumn(name = "s_category_id", nullable = false) // 외래 키 이름 수정
    private Category sCategory;


    @Column(nullable = false, length = 50)
    private String name;



    // 생성자
    @Builder
    private Product(User user, Category bCategory, Category mCategory, Category sCategory, String tag, String title, String name, int views, int price,
                    String sido, String sigungu, String bname, String description, String mainImage) {

        this.user = user;
        this.bCategory = bCategory;
        this.mCategory = mCategory;
        this.sCategory = sCategory;
        this.name = name;
    }

}
