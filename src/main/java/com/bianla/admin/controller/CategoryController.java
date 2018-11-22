package com.bianla.admin.controller;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.Category;
import com.bianla.admin.service.ICategoryService;
import com.bianla.admin.utils.ActionUserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZHL on 2018/11/16.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询新闻所有类目
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/list")
    public Result getNewsCategoryList(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return new Result(ResultEnum.EMPTY_TOKEN);
        }
        Result result = ActionUserUtil.getUserId(token, request, response);
        if(result.getCode() != 1){
            return result;
        }
        return categoryService.queryAll();
    }

    /**
     * 添加新闻类目
     * @param request
     * @param response
     * @param param
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/add")
    public Result addsCategory(HttpServletRequest request, HttpServletResponse response,
                               @Validated Category param, BindingResult bindingResult){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return new Result(ResultEnum.EMPTY_TOKEN);
        }
        Result result = ActionUserUtil.getUserId(token, request, response);
        if(result.getCode() != 1){
            return result;
        }
        if(bindingResult.hasErrors()){
            return new Result(ResultEnum.OTHER_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        return categoryService.addCategory(param);
    }

    /**
     * 编辑新闻类目
     * @param request
     * @param response
     * @param param
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/edit")
    public Result editsCategory(HttpServletRequest request, HttpServletResponse response,
                                @Validated Category param, BindingResult bindingResult){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return new Result(ResultEnum.EMPTY_TOKEN);
        }
        Result result = ActionUserUtil.getUserId(token, request, response);
        if(result.getCode() != 1){
            return result;
        }
        if(bindingResult.hasErrors()){
            return new Result(ResultEnum.OTHER_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        return categoryService.updateCategory(param);
    }

    /**
     * 删除新闻类目
     * @param request
     * @param response
     * @param id
     * @return
     */
    @PostMapping(value = "/{id}/delete")
    public Result deletesCategory(HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable("id") Integer id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return new Result(ResultEnum.EMPTY_TOKEN);
        }
        Result result = ActionUserUtil.getUserId(token, request, response);
        if(result.getCode() != 1){
            return result;
        }
        return categoryService.deleteCategory(id);
    }
}
