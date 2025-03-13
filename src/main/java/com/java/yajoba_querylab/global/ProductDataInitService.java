package com.java.yajoba_querylab.global;


import com.java.yajoba_querylab.domain.category.entity.Category;
import com.java.yajoba_querylab.domain.product.ProductRepository;
import com.java.yajoba_querylab.domain.product.entity.Product;
import com.java.yajoba_querylab.domain.review.ReviewRepository;
import com.java.yajoba_querylab.domain.review.entity.Review;
import com.java.yajoba_querylab.domain.user.UserRepository;
import com.java.yajoba_querylab.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDataInitService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductDummyService productDummyService;
    private final ReviewRepository reviewRepository;

    private final UserInitService userInitService;
    private final ProfileInitService profileInitService;

    public void run() throws Exception {
        long startTime = System.currentTimeMillis();
        userInitService.createDummyUser();
        profileInitService.initProfile();
        List<Product> products = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();
        List<User> testUsers = userRepository.findAll();
        for (User user : testUsers) {
            for (int i = 0; i < 1000; i++) {
                String productName = productDummyService.getRandomProductName();
                List<Category> categories = productDummyService.getRandomCategory();
                Category bcategory = categories.get(0);
                Category mcategory = categories.get(1);
                Category scategory = categories.get(2);

                Product product = Product.builder()
                        .user(user)
                        .name(productName)
                        .bCategory(bcategory)
                        .mCategory(mcategory)
                        .sCategory(scategory)
                        .build();

                products.add(product);
                productDummyService.setRandomReview(product, user);

            }
        }

        productRepository.saveAll(products);
        reviewRepository.saveAll(ProductDummyService.getReviews());

        long endTime = System.currentTimeMillis(); // 종료 시간 기록
        long duration = endTime - startTime; // 실행 시간 계산

    }

}

