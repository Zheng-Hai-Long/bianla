package com.bianla.admin.controller;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.ActionUser;
import com.bianla.admin.service.IActionUserService;
import com.bianla.admin.utils.ActionUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2018/10/28.
 */

@RestController
@RequestMapping("/action/user")
public class ActionUserController {

    @Autowired
    private IActionUserService actionUserService;

    @PostMapping(value = "/login")
    public Result Login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("userName") String userName,
                        @RequestParam("password") String passWord){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Result result = actionUserService.login(userName, passWord);
        if(result.getCode() == 1){
            ActionUser actionUser = (ActionUser) result.getData();
            String token = ActionUserUtil.login(actionUser.getId(), response, request);
            return new Result(ResultEnum.SUCCESS, token);
        }
        return result;
    }


}
