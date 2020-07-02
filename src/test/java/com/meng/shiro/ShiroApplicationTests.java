package com.meng.shiro;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.shiro.config.DruidProperties;
import com.meng.shiro.config.MyProperties;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;
import com.meng.shiro.manager.UserManager;
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

    @Autowired
    private UserManager userManager;

    @Test
    public void contextLoads() {

        IPage<UserDTO> iPage = userService.listUsers(new Page<>());
        System.out.println(iPage);
    }

    @Test
    public void listUserTest() {
        IPage<UserDTO> iPage = userService.listUsers(new Page<>(1, 1));

        List<UserDTO> records = iPage.getRecords();

        for (UserDTO dto : records) {
            System.out.println(dto);
        }

    }

    @Test
    public void getUserLocked() {
        boolean locked = userManager.getUserLocked("dudu");

        System.out.println(locked);
    }

    @Test
    public void testPamter(){
        System.out.println("name = " + myProperties);
        System.out.println(druidProperties);
        System.out.println("------------------");
    }

    @Test
    public void aaa(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("dudu");
        userDTO.setPhone("123");

        User user = userDTO.doForward(userDTO);
        System.out.println(user);
    }

    @Test
    public void getUserByUsername(){

        UserDTO user = userService.getUser("dudu");

        System.out.println(user);
    }

}
