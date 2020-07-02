package com.meng.shiro.service;

import com.meng.shiro.entity.dto.PermissionDTO;

import java.util.List;

public interface PermissionService {

    /**
     * 查询单个资源
     *
     * @param permissionId 主键
     * @return 资源
     */
    PermissionDTO getPermission(Long permissionId);

    /**
     * 查询资源集合
     *
     * @return 资源集合
     */
    List<PermissionDTO> listPermissions();

    /**
     * 插入一条记录
     *
     * @param permissionDTO 实体对象
     * @return 逻辑值
     */
    boolean savePermission(PermissionDTO permissionDTO);

    /**
     * 主键存在则更新记录，否则插入一条记录
     *
     * @param permissionDTO 实体对象
     * @return 逻辑值
     */
    boolean saveOrUpdatePermission(PermissionDTO permissionDTO);

    /**
     * 修改一条记录
     *
     * @param permissionDTO 实体对象
     * @return 逻辑值
     */
    boolean updatePermission(PermissionDTO permissionDTO);

    /**
     * 删除一条记录
     *
     * @param permissionId 主键
     * @return 逻辑值
     */
    boolean deletePermission(Long permissionId);
}
