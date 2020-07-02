package com.meng.shiro;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;
import com.meng.shiro.service.UserService;
import com.meng.shiro.util.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author mengli
 * @create 2019/11/7
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    @Autowired
    UserService userService;

    @Test
    public void logOutPutTest() {
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();

        IPage<UserDTO> iPage = userService.listUsers(new Page<UserDTO>(1, 10));

        System.out.println(iPage);

        log.error("getExceptionLogger   日志测试");
        log1.info("getBussinessLogger   日志测试");
        log2.debug("getDBLogger   日志测试");
    }
}
