package com.meng.user;

import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.repository.mapper.PermissionMapper;
import com.meng.user.service.system.UserService;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 *  测试驱动开发
 *
 *      没有测试之前不要写任何功能代码
 *      只编写恰好能够体现一个失败情况的测试代码
 *      只编写恰好能通过测试的功能代码
 *
 *  测试的FIRST准则
 *
 *      快速（Fast）测试应该够快，尽量自动化。
 *      独立（Independent） 测试应该应该独立。不要相互依赖
 *      可重复（Repeatable） 测试应该在任何环境上都能重复通过。
 *      自我验证（Self-Validating） 测试应该有bool输出。不要通过查看日志这种低效率方式来判断测试是否通过
 *      及时（Timely） 测试应该及时编写，在其对应的生产代码之前编写
 *
 *  整洁代码准则
 *
 *      优雅且高效、直截了当、减少依赖、只做好一件事
 *      简单直接
 *      可读、可维护、单元测试
 *      不要重复、单一职责、表达力
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserService userService;

    @Test
    public void shiroProperties() {

        System.out.println("--------------------");

        List<PermissionDO> permissionDOS = permissionMapper.selectList(null);

        for (PermissionDO permissionDO : permissionDOS) {
            System.out.println(permissionDO);
        }

        System.out.println("--------------------");
    }


    @Test
    public void updatePassword() {

        // 3428db74ed0298c8f1becc05e6d1258391dda82ad776f0024e5031859c1787fa

        String password = "123456";
        String salt = "fece55e12415be20dea3a31ddbb8482f";

        String encryptionPassword = userService.encryption(password, salt);

        System.out.println(encryptionPassword);
        System.out.println(encryptionPassword);
        System.out.println(encryptionPassword);

    }


    @Test
    public void aa() {

        byte[] storedBytes = CodecSupport.toBytes("3428db74ed0298c8f1becc05e6d1258391dda82ad776f0024e5031859c1787fa");

        byte[] storedBytes1 = Hex.decode(storedBytes);
        // byte[] storedBytes2 = Base64.decode(storedBytes);

        System.out.println(Arrays.toString(storedBytes1));

    }

}
