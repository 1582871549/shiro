package com.meng.shiro;

import com.meng.shiro.config.DruidProperties;
import com.meng.shiro.config.MyProperties;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;
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

        List<UserDTO> list = userService.listUsers();
        System.out.println(list);
    }

    @Test
    public void listUserTest() {
        List<UserDTO> dtos = userService.listUsers();

        System.out.println("list : " + dtos);

        for (UserDTO dto : dtos) {
            System.out.println(dto);
        }

    }

    @Test
    public void testPamter() {
        System.out.println("name = " + myProperties);
        System.out.println(druidProperties);
        System.out.println("------------------");
    }

    @Test
    public void aaa() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("dudu");
        userDTO.setPhone("123");

        User user = userDTO.doForward(userDTO);
        System.out.println(user);
    }

}
