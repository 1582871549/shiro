/**
 * FileName: DTOConvert
 * Author:   大橙子
 * Date:     2019/10/8 16:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.entity;

import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/10/8
 * @since 1.0.0
 */
public interface UserDTOConvert extends Convert<UserDTO, User> {

    /**
     * 转换userDTO为userPO
     *
     * @param userDTO 用户传输类
     * @return 用户实体类
     */
    @Override
    default User doForward(UserDTO userDTO) {
        User user = new User();
        copyPropertiesIgnoreNull(userDTO, user);
        return user;
    }

    /**
     * 转换userPO为userDTO
     *
     * @param user 用户实体类
     * @return 用户传输类
     */
    @Override
    default UserDTO doBackward(User user) {
        UserDTO userDTO = new UserDTO();
        copyPropertiesIgnoreNull(user, userDTO);
        return userDTO;
    }

}
