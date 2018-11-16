package com.bianla.admin.service;

import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.ActionUser;

/**
 * Created by admin on 2018/10/28.
 */
public interface IActionUserService {

    Result queryByParam(ActionUser param);

    Result login(String userName, String password);

    ActionUser queryById(Integer userId);
}
