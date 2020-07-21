/**
 * FileName: MyProperties
 * Author:   大橙子
 * Date:     2019/8/27 17:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/27
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix = MyProperties.PREFIX)
public class MyProperties {

    static final String PREFIX = "my";

    private String name;
}
