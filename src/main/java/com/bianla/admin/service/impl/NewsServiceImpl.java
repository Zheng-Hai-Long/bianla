package com.bianla.admin.service.impl;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.constant.NewsConstant;
import com.bianla.admin.dao.NewsMapper;
import com.bianla.admin.dto.NewsDTO;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.News;
import com.bianla.admin.repostory.NewsRepository;
import com.bianla.admin.service.INewsService;
import com.bianla.admin.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by ZHL on 2018/11/16.
 */
@Service
public class NewsServiceImpl implements INewsService {

    private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Result addNews(News data) {
        logger.info("addNews data = {}", data);
        data.setCreateTime(new Date());
        data.setUpdateTime(new Date());
        data.setState(100);//默认草稿
        News record = newsRepository.save(data);
        if(record.getId() != null){
            return ResultUtil.SUCCESS();
        }
        return ResultUtil.ERROR();
    }

    @Override
    public Result updateNews(News data) {
        logger.info("updateNews data = {}", data);
        data.setUpdateTime(new Date());
        int res = newsMapper.update(data);
        if(res <= 0){
            return ResultUtil.ERROR();
        }
        return ResultUtil.SUCCESS();
    }

    @Override
    public Result deleteNews(Integer id) {
        logger.info("deleteNews id = {}", id);
        News news = new News();
        news.setId(id);
        newsRepository.delete(news);
        return ResultUtil.SUCCESS();
    }

    @Override
    public Result findNewsByParam(News param, int pageNum, int pageSize) {
        logger.info("findNewsByParam News = {}", param);

        PageHelper.startPage(pageNum, pageSize);
        List<NewsDTO> list = newsMapper.queryByParam(param);
        if(!CollectionUtils.isEmpty(list)){
            for (NewsDTO news : list) {
                if(StringUtils.isNotBlank(news.getCoverimageUrl())) {
                    news.setCoverimageUrl(NewsConstant.NEWS_CONVER_IMAGE_URL + "/" + news.getCoverimageUrl());
                }
            }
        }

        PageInfo<NewsDTO> page = new PageInfo<>(list);

        if(page == null || page.getTotal() == 0){
            return ResultUtil.EMPTY_DATA();
        }
        ResultUtil util = new ResultUtil();
        return util.SUCCESS(page);
    }

    @Override
    public Result findNewsDetail(Integer id) {
        logger.info("findNewsDetail id = {}" + id);

        NewsDTO newsDTO= newsMapper.queryById(id);
        if(newsDTO != null){
            if(StringUtils.isNotBlank(newsDTO.getCoverimageUrl())) {
                newsDTO.setCoverimageUrl(NewsConstant.NEWS_CONVER_IMAGE_URL + "/" + newsDTO.getCoverimageUrl());
            }
           return new Result(ResultEnum.SUCCESS, newsDTO);
        }

        return new Result(ResultEnum.EMPTY_DATA);
    }
}
