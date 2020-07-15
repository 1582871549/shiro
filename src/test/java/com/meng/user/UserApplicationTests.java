package com.meng.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.user.common.config.DruidProperties;
import com.meng.user.service.system.entity.dto.UserDTO;
import com.meng.user.repository.entity.User;
import com.meng.user.service.system.RoleService;
import com.meng.user.service.system.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Autowired
    DruidProperties druidProperties;


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
    public void testPamter(){
        System.out.println(druidProperties);
        System.out.println("------------------");
    }

    @Test
    public void aaa(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("dudu");
        userDTO.setPhone("123");

        User user = null;
        System.out.println(user);
    }

    @Test
    public void getUserByUsername(){

        UserDTO user = userService.getUser("dudu");

        System.out.println(user);
    }

}
