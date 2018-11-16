package com.bianla.admin.service.impl;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.Category;
import com.bianla.admin.entity.News;
import com.bianla.admin.repostory.CategoryRepository;
import com.bianla.admin.service.ICategoryService;
import com.bianla.admin.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by ZHL on 2018/11/16.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Result queryAll() {
        List<Category> categoryList = categoryRepository.findAll();
        if(CollectionUtils.isEmpty(categoryList)){
            return ResultUtil.EMPTY_DATA();
        }
        return new Result(ResultEnum.SUCCESS, categoryList);
    }

    @Override
    public Result addCategory(Category data) {
        logger.info("addNews data = {}", data);
        Category record = categoryRepository.save(data);
        if(record.getId() != null){
            return ResultUtil.SUCCESS();
        }
        return ResultUtil.ERROR();
    }

    @Override
    public Result updateCategory(Category data) {
        logger.info("updateNews data = {}", data);
        Category record = categoryRepository.save(data);
        return ResultUtil.SUCCESS();
    }

    @Override
    public Result deleteCategory(Integer id) {
        logger.info("deleteNews id = {}", id);
        Category category = new Category();
        category.setId(id);
        categoryRepository.delete(category);
        return ResultUtil.SUCCESS();
    }
}
