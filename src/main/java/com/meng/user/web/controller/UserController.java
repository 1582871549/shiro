package com.meng.user.web.controller;

import com.meng.user.service.system.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequiresPermissions("user")
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String index() {

        String[] arr = new String[]{"docker", "vue", "java"};

        String string = Arrays.toString(arr);

        return string;
    }


}
