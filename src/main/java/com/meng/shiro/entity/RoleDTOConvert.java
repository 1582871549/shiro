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

import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.po.Role;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/10/8
 * @since 1.0.0
 */
public interface RoleDTOConvert extends Convert<RoleDTO,Role> {

    /**
     * 转换userDTO为userPO
     *
     * @param roleDTO 角色传输类
     * @return 角色实体类
     */
    @Override
    default Role doForward(RoleDTO roleDTO) {
        Role role = new Role();
        copyPropertiesIgnoreNull(roleDTO, role);
        return role;
    }

    /**
     * 转换userPO为userDTO
     *
     * @param role 用户实体类
     * @return 用户传输类
     */
    @Override
    default RoleDTO doBackward(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        copyPropertiesIgnoreNull(role, roleDTO);
        return roleDTO;
    }

}
