package com.java.yajoba_querylab.global;

import com.java.yajoba_querylab.domain.category.CategoryRepository;
import com.java.yajoba_querylab.domain.category.entity.Category;
import com.java.yajoba_querylab.domain.product.entity.Product;
import com.java.yajoba_querylab.domain.review.ReviewRepository;
import com.java.yajoba_querylab.domain.review.entity.Review;
import com.java.yajoba_querylab.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ProductDummyService {

    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    // 리뷰 데이터를 저장할 static 필드
    private static final List<Review> reviews = new ArrayList<>();

    // 지역을 랜덤으로 선택하여 반환하는 메서드

    public String getRandomProductName() {
        final String[] productName = {"삼성", "에플", "LG"};
        final String[] productName2 = {"노트북", "휴대폰", "냉장고", "세탁기", "TV", "이어폰", "스피커", "PC"};
        String randomProductName = productName[(int)(Math.random()*productName.length)];
        String randomProductName2 = productName2[(int)(Math.random()*productName2.length)];
        return randomProductName + randomProductName2;
    }

    public void setRandomReview(Product product, User user) {
        String[] contentsList = {
                "판매자분이 너무 친절해요",
                "물건 상태가 많이 안좋네요 감안하고 사용하시는거 추천합니다.",
                "굿",
                "물건에 살짝 스크레치가 났는데 전부 변상하라고 하네요.. 참고하세요",
                "너무 잘 썼습니다 감사합니다.",
                "대여 기간이 적당하고, 사용하기 편했어요!",
                "장비 상태가 아주 좋습니다. 대여해서 잘 썼어요.",
                "사이즈가 좀 작았지만, 나름 괜찮았습니다.",
                "대여 후 사용 방법이 간단해서 좋았어요.",
                "반납 과정이 매끄러워서 좋았습니다.",
                "서비스가 빠르고 간편해서 재대여할 예정이에요.",
                "대여가 가능한 기간이 길어서 여러 번 사용했어요.",
                "친절한 설명 덕분에 처음 사용했지만 문제없이 썼습니다.",
                "대여 비용이 적당해서 부담이 없었습니다.",
                "장비를 사용해 보니 기대 이상이에요!"
        };
        int count = (int)(Math.random()*2); // 한 상품당 리뷰가 1 ~ N개 생성

        for (int i = 0; i < count; i++) {
            int randomIndex = (int)(Math.random()*contentsList.length);
            String content = contentsList[randomIndex];
            int rating = (int)(Math.random()*5) + 1;

            Review review = Review.builder()
                    .content(content)
                    .product(product)
                    .rating(rating)
                    .user(user)
                    .build();

            reviews.add(review);
        }
    }

    public List<Category> getRandomCategory() {
        List<Category> bcategoryList = categoryRepository.findAllNoParent();
        int randomIndex = (int)(Math.random()*bcategoryList.size());
        Category bcategory = bcategoryList.get(randomIndex);

        List<Category> mcategoryList = categoryRepository.findByParent(bcategory);
        randomIndex = (int)(Math.random()*mcategoryList.size());
        Category mcategory = mcategoryList.get(randomIndex);

        List<Category> scategoryList = categoryRepository.findByParent(mcategory);
        randomIndex = (int)(Math.random()*scategoryList.size());
        Category scategory = scategoryList.get(randomIndex);

        return Arrays.asList(bcategory, mcategory, scategory);
    }

    public static List<Review> getReviews() {
        return new ArrayList<>(reviews);
    }
}
