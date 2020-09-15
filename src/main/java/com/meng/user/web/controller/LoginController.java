package com.meng.user.web.controller;

import com.meng.user.repository.entity.UserDO;
import com.meng.user.service.system.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        System.out.println("进入登录页");

        return "登录页";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserDO userDO) {

        String token = userService.login(userDO);

        return token;
    }

    @RequiresAuthentication
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        System.out.println("进入主页");

        return "主页";
    }


}
