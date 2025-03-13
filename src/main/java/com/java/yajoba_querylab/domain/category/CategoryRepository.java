package com.java.yajoba_querylab.domain.category;

import com.java.yajoba_querylab.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends  JpaRepository<Category,Integer> {
    Optional<Category> findByName(String name);
    @Query("SELECT c FROM Category c WHERE c.parent IS NULL")
    List<Category> findAllNoParent();
    List<Category> findByParent(Category category);
}
