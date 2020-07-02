package com.meng.shiro.entity;

import com.meng.shiro.entity.dto.PermissionDTO;
import com.meng.shiro.entity.po.Permission;

/**
 * @author 大橙子
 * @create 2019/10/8
 * @since 1.0.0
 */
public interface PermissionDTOConvert extends Convert<PermissionDTO, Permission> {

    /**
     * 转换userDTO为userPO
     *
     * @param resourceDTO 用户传输类
     * @return 用户实体类
     */
    @Override
    default Permission doForward(PermissionDTO resourceDTO) {
        Permission resource = new Permission();
        copyPropertiesIgnoreNull(resourceDTO, resource);
        return resource;
    }

    /**
     * 转换userPO为userDTO
     *
     * @param resource 用户实体类
     * @return 用户传输类
     */
    @Override
    default PermissionDTO doBackward(Permission resource) {
        PermissionDTO resourceDTO = new PermissionDTO();
        copyPropertiesIgnoreNull(resource, resourceDTO);
        return resourceDTO;
    }

}
