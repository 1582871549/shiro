package com.meng.user;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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
public class ShiroTest extends BaseTest {

    @Test
    public void testHasRole() {

        login("classpath:ini/shiro-role.ini", "zhang", "123");

        boolean hasRole = getSubject().hasRole("admin");

        boolean hasAllRoles = getSubject().hasAllRoles(Arrays.asList("admin", "root"));

        boolean[] result = getSubject().hasRoles(Arrays.asList("admin", "root", "dudu"));

        System.out.println("hasRole " + hasRole);
        System.out.println("hasAllRoles " + hasAllRoles);
        System.out.println("result " + Arrays.toString(result));
    }

    @Test
    public void testCheckRole() {

        login("classpath:ini/shiro-role.ini", "zhang", "123");

        try {
            getSubject().checkRole("admin");

            getSubject().checkRole("adminas");

            getSubject().checkRoles("admin", "root");

        } catch (UnauthorizedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsPermitted() {

        login("classpath:ini/shiro-permission.ini", "zhang", "123");

        boolean permittedCreate = getSubject().isPermitted("user:create");

        boolean permittedView = getSubject().isPermitted("user:view");

        boolean permittedAll = getSubject().isPermittedAll("user:update", "user:delete");

        System.out.println("permittedCreate " + permittedCreate);
        System.out.println("permittedView " + permittedView);
        System.out.println("permittedAll " + permittedAll);
    }

    @Test
    public void testCheckPermission() {

        login("classpath:ini/shiro-permission.ini", "zhang", "123");

        try {
            getSubject().checkPermission("user:create");

            getSubject().checkPermissions("user:delete", "user:update");

            getSubject().checkPermissions("user:view");

        } catch (UnauthorizedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testBitIsPermitted() {

        login("classpath:ini/shiro-authorizer.ini", "zhang", "123");
        //判断拥有权限：user:create
        Assert.assertTrue(getSubject().isPermitted("user1:update"));
        Assert.assertTrue(getSubject().isPermitted("user2:update"));
        //通过二进制位的方式表示权限
        Assert.assertTrue(getSubject().isPermitted("+user1+2"));//新增权限
        Assert.assertTrue(getSubject().isPermitted("+user1+8"));//查看权限
        Assert.assertTrue(getSubject().isPermitted("+user2+10"));//新增及查看

        Assert.assertFalse(getSubject().isPermitted("+user1+4"));//没有删除权限

        Assert.assertTrue(getSubject().isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限
    }

    @Test(expected = ExcessiveAttemptsException.class)
    public void testRetryLimitHashedCredentialsMatcherWithMyRealm() {
        for(int i = 1; i <= 5; i++) {
            try {
                login("classpath:ini/shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "1234");
            } catch (Exception e) {/*ignore*/}
        }
        login("classpath:ini/shiro-retryLimitHashedCredentialsMatcher.ini", "liu", "234");
    }
}
