package com.bianla.admin.service.impl;

import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.ActionUser;
import com.bianla.admin.repostory.ActionUserRepostory;
import com.bianla.admin.service.IActionUserService;

import com.bianla.admin.utils.MD5Util;
import com.bianla.admin.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 2018/10/28.
 */
@Service("actionUserService")
public class ActionUserServiceImpl implements IActionUserService {

    private static final Logger logger = LoggerFactory.getLogger(ActionUserServiceImpl.class);

    @Autowired
    private ActionUserRepostory actionUserRepostory;

    @Override
    public Result queryByParam(ActionUser param) {

        logger.info("queryByParam ActionUser = " + param);

        PageHelper.startPage(1,1);
        List<ActionUser> list = actionUserRepostory.findAll();

        PageInfo<ActionUser> page = new PageInfo<>(list);

        if(page == null || page.getTotal() == 0){
            return ResultUtil.EMPTY_DATA();
        }
        ResultUtil util = new ResultUtil();
        return util.SUCCESS(page);
    }

    @Override
    public Result login(String userName, String password) {

        logger.info("login userName = " + userName + "，password = " + password);

        password = MD5Util.MD5Encode(userName + password);

        ActionUser user = actionUserRepostory.findByActionNameAndActionPwd(userName, password);
        if(user == null){
            return ResultUtil.ERROR();
        }
        ResultUtil util = new ResultUtil();
        return util.SUCCESS(user);
    }

    @Override
    public ActionUser queryById(Integer userId) {

        logger.info("queryById userId = " + userId);

        Optional<ActionUser> actionUser = actionUserRepostory.findById(userId);
        if(actionUser.isPresent()){
            return actionUser.get();
        }
        return null;
    }
}
