package com.bianla.admin.controller;

import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.ActionUser;
import com.bianla.admin.service.IActionUserService;
import com.bianla.admin.utils.ActionUserUtil;
import com.bianla.admin.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/list")
    public Result GetActionUserList(){
        return actionUserService.queryByParam(null);
    }

    @PostMapping(value = "/login")
    public Result Login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("userName") String userName,
                        @RequestParam("password") String passWord){
        Result result = ActionUserUtil.getUserId(request);
        if(result.getCode() == 1){
            return ResultUtil.SUCCESS();
        }
         result = actionUserService.login(userName, passWord);
        if(result.getCode() == 1){
            ActionUser actionUser = (ActionUser) result.getData();
            ActionUserUtil.login(actionUser.getId(), response, request);
        }
        return result;
    }



}
