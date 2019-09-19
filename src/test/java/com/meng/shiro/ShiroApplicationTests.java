package com.meng.shiro;

import com.meng.shiro.bean.dto.RoleDTO;
import com.meng.shiro.bean.dto.UserDTO;
import com.meng.shiro.config.DruidProperties;
import com.meng.shiro.config.MyProperties;
import com.meng.shiro.service.RoleService;
import com.meng.shiro.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    MyProperties myProperties;
    @Autowired
    DruidProperties druidProperties;

    @Test
    public void contextLoads() {
        List<UserDTO> users = userService.listUser();
        System.out.println(users);
    }

    @Test
    public void listRoleTest() {
        List<RoleDTO> roleDTOList = roleService.listRole();
        for (RoleDTO roleDTO : roleDTOList) {
            System.out.println(roleDTO);
        }

    }

    @Test
    public void testPamter(){
        System.out.println("name = " + myProperties);
        System.out.println(druidProperties);
        System.out.println("------------------");
    }

}
