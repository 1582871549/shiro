package com.meng.user;

import com.meng.user.common.model.DruidProperties;
import com.meng.user.common.model.ShiroProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class ConfigTest {

    @Autowired
    private ShiroProperties shiroProperties;

    @Autowired
    private DruidProperties druidProperties;

    @Test
    public void shiroProperties() {

        System.out.println("--------------------");
        System.out.println(shiroProperties.toString());
        System.out.println("--------------------");
    }

    @Test
    public void druidProperties() {

        System.out.println("--------------------");
        System.out.println(druidProperties.toString());
        System.out.println("--------------------");
    }

}
