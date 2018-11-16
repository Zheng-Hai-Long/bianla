package com.bianla.admin.service;

import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.Category;

/**
 * Created by ZHL on 2018/11/16.
 */
public interface ICategoryService {

    Result queryAll();

    Result addCategory(Category data);

    Result updateCategory(Category data);

    Result deleteCategory(Integer id);
}
