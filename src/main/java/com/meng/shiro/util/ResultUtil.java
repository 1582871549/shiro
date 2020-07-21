/**
 * FileName: ResultUtil
 * Author:   大橙子
 * Date:     2019/10/18 17:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.util;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
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
        return null != result && result >= 1;
    }
}
