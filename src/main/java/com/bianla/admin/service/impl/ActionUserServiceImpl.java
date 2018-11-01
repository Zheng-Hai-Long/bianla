package com.bianla.admin.service.impl;

import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.ActionUser;
import com.bianla.admin.repostory.ActionUserRepostory;
import com.bianla.admin.service.IActionUserService;

import com.bianla.admin.utils.MD5Util;
import com.bianla.admin.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/10/28.
 */
@Service("actionUserService")
public class ActionUserServiceImpl implements IActionUserService {

    @Autowired
    private ActionUserRepostory actionUserRepostory;

    @Override
    public Result queryByParam(ActionUser param) {

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

        password = MD5Util.MD5Encode(userName + password);

        ActionUser user = actionUserRepostory.findByActionNameAndActionPwd(userName, password);
        if(user == null){
            return ResultUtil.ERROR();
        }
        ResultUtil util = new ResultUtil();
        return util.SUCCESS(user);
    }
}
