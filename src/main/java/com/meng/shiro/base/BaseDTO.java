/**
 * FileName: BaseVO
 * Author:   大橙子
 * Date:     2019/3/25 23:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/3/25
 * @since 1.0.0
 */

@Data
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = -8902533046347688291L;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;
    /**
     * 是否锁定(0:false 1:true)
     */
    private Boolean locked;
}
