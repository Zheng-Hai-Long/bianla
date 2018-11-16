package com.bianla.admin.service;

import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.News;

/**
 * Created by ZHL on 2018/11/16.
 */
public interface INewsService {

    Result addNews(News data);

    Result updateNews(News data);

    Result deleteNews(Integer id);

    Result findNewsByParam(News param, int pageNum, int pageSize);

    Result findNewsDetail(Integer id);
}
