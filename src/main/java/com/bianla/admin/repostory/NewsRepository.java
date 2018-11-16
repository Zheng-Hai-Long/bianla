package com.bianla.admin.repostory;

import com.bianla.admin.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZHL on 2018/11/16.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}
