package com.meng.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.user.common.config.DruidProperties;
import com.meng.user.common.config.ShiroProperties;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.service.system.PermissionService;
import com.meng.user.service.system.RoleService;
import com.meng.user.service.system.UserService;
import com.meng.user.service.system.entity.dto.PermissionDTO;
import com.meng.user.service.system.entity.dto.RoleDTO;
import com.meng.user.service.system.entity.dto.UserDTO;
import com.meng.user.shiro.realm.UserRealm;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @Autowired
    UserRealm userRealm;

    @Autowired
    DruidProperties druidProperties;
    @Autowired
    ShiroProperties shiroProperties;

    @Test
    public void password() {

        String password = userService.updatePassword("123");

        System.out.println("----------------");
        System.out.println(password);
        System.out.println("----------------");
    }

    @Test
    public void contextLoads() {

        IPage<UserDO> iPage = userService.listUsers(new Page<>());
        System.out.println(iPage);
    }

    @Test
    public void listUserTest() {

        IPage<UserDO> iPage = userService.listUsers(new Page<>(1, 1));

        List<UserDO> records = iPage.getRecords();

        for (UserDO userDO : records) {
            System.out.println(userDO);
        }

    }

    @Test
    public void testPamter() {
        System.out.println("------------------");
        System.out.println(druidProperties);
        System.out.println(shiroProperties);
        System.out.println("------------------");
    }

    @Test
    public void aaa() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("dudu");
        userDTO.setPhone("123");

        boolean b = userService.saveUser(userDTO);

        System.out.println(b);
    }

    @Test
    public void getUserByUsername() {

        UserDTO user = userService.getUser("dudu");

        System.out.println(user);
    }

    @Test
    public void getClassName() {

        UserDTO user = new UserDTO();

        String name = user.getClass().getSimpleName();

        System.out.println(name);
    }

    @Test
    public void listPermissions() {

        List<PermissionDTO> list = permissionService.listPermissions(2L);

        for (PermissionDTO permissionDTO : list) {
            System.out.println(permissionDTO);
        }

    }

    @Test
    public void listRoles() {

        List<RoleDTO> list = roleService.listRoles(1L);

        for (RoleDTO roleDTO : list) {
            System.out.println(roleDTO);
        }

    }

    @Test
    public void setRolesAndPermissions() {

        SimpleAuthorizationInfo info = userRealm.setRoles(1L);

        System.out.println("--------------------");
        System.out.println(info);
    }

}
