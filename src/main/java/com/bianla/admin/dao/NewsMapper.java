package com.bianla.admin.dao;

import com.bianla.admin.dto.NewsDTO;
import com.bianla.admin.entity.News;

import java.util.List;

/**
 * Created by ZHL on 2018/11/16.
 */
public interface NewsMapper {

    int update(News data);

    List<NewsDTO> queryByParam(News param);

    NewsDTO queryById(Integer id);
}
