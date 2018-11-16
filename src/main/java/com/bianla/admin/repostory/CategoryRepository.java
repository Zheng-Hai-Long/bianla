package com.bianla.admin.repostory;

import com.bianla.admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZHL on 2018/11/16.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
