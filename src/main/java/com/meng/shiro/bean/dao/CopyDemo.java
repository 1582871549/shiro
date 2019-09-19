/**
 * FileName: Demo
 * Author:   大橙子
 * Date:     2019/4/1 10:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.bean.dao;

import com.meng.shiro.config.MyProperties;
import com.meng.shiro.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/4/1
 * @since 1.0.0
 */
public class CopyDemo {

    @Autowired
    private MyProperties myProperties;

    public void aa () {
        System.out.println(myProperties.getName());
    }

    public static void main(String[] args) {

        new CopyDemo().aa();

        // UserDO user = new UserDO();
        // user.setUpdateTime(DateUtil.getDateTimeStr());
        //
        // RoleDO role = new RoleDO();
        // role.setCreateTime(DateUtil.getDateTimeStr());
        //
        // System.out.println("user   :   " + user);
        // System.out.println("role   :   " + role);
        // System.out.println();
        //
        // copyPropertiesIgnoreNull(user, role);
        //
        // System.out.println("user   :   " + user);
        // System.out.println("role   :   " + role);
    }

    public static String[] getNullPropertyNames (Object source) {

        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
}
