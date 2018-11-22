package com.bianla.admin.controller;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.News;
import com.bianla.admin.service.INewsService;
import com.bianla.admin.service.IUploadService;
import com.bianla.admin.utils.ActionUserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZHL on 2018/11/16.
 */

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private IUploadService uploadService;

    @GetMapping("/{id}/detail")
    public Result getNewsDetail(HttpServletRequest request, HttpServletResponse response,
                                @PathVariable("id") Integer id){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return newsService.findNewsDetail(id);
    }

    /**
     * 添加新闻
     * @param request
     * @param response
     * @param param
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/add")
    public Result addNews(HttpServletRequest request, HttpServletResponse response,
                          @Validated News param, BindingResult bindingResult){
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
        return newsService.addNews(param);
    }

    /**
     * 编辑新闻
     */
    @PostMapping(value = "/edit")
    public Result editNews(HttpServletRequest request, HttpServletResponse response,
                           @Validated News param, BindingResult bindingResult){
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
        return newsService.updateNews(param);
    }

    /**
     * 删除新闻
     * @param request
     * @param response
     * @param id
     * @return
     */
    @PostMapping(value = "/{id}/delete")
    public Result deleteNews(HttpServletRequest request, HttpServletResponse response,
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
        return newsService.deleteNews(id);
    }

    /**
     * 后台新闻列表分页 100草稿、200发布中、300隐藏
     * @param request
     * @param response
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @GetMapping(value = "admin/list")
    public Result getAdminNewsList(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   News param){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return new Result(ResultEnum.EMPTY_TOKEN);
        }
        Result result = ActionUserUtil.getUserId(token,request, response);
        if(result.getCode() != 1){
            return result;
        }
        return newsService.findNewsByParam(param, pageNum, pageSize);
    }

    /**
     * 新闻列表分页（发布中的新闻）
     * @param request
     * @param response
     * @param pageNum
     * @param pageSize
     * @param param
     * @return
     */
    @GetMapping(value = "/list")
    public Result getNewsList(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                             News param){
        response.setHeader("Access-Control-Allow-Origin", "*");
        param.setState(200);
        return newsService.findNewsByParam(param, pageNum, pageSize);
    }

    /**
     * 上传图片
     * @param request
     * @param response
     * @param file
     * @return
     */
    @PostMapping(value = "/upload/image")
    public Result uploadImage(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("file")MultipartFile file){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return new Result(ResultEnum.EMPTY_TOKEN);
        }
        Result result = ActionUserUtil.getUserId(token, request, response);
        if(result.getCode() != 1){
            return result;
        }
        return uploadService.uploadNewsCoverImage(file);
    }

    /**
     * 发布新闻
     * @param request
     * @param response
     * @param id
     * @return
     */
    @PostMapping("/{id}/send")
    public Result sendNews(HttpServletRequest request, HttpServletResponse response,
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
        News news = new News();
        news.setState(200);
        news.setId(id);
        return newsService.updateNews(news);
    }

    /**
     * 隐藏新闻
     * @param request
     * @param response
     * @param id
     * @return
     */
    @PostMapping("/{id}/hide")
    public Result hideNews(HttpServletRequest request, HttpServletResponse response,
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
        News news = new News();
        news.setState(300);
        news.setId(id);
        return newsService.updateNews(news);
    }


}
