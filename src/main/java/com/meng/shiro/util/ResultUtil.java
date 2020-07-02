package com.meng.shiro.util;

/**
 * @author 大橙子
 * @create 2019/10/18
 * @since 1.0.0
 */
public class ResultUtil {

    /**
     * 判断数据库操作是否成功
     *
     * @param result 数据库操作返回影响条数
     * @return boolean
     */
    public static boolean returnBool(Integer result) {
        return result != null && result > 0;
    }
}
