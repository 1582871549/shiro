package com.meng.shiro.manager;

import com.meng.shiro.entity.dto.RoleDTO;

import java.util.List;

/**
 * @author 大橙子
 * @create 2019/8/12
 * @since 1.0.0
 */
public interface RoleManager {

    /**
     * 添加角色-权限之间关系
     *
     * @param roleId 角色id
     * @param permissionIds 权限ids
     */
    void addCorrelationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     *
     * @param roleId 角色id
     * @param permissionIds 权限ids
     */
    void removeCorrelationPermissions(Long roleId, Long... permissionIds);

    /**
     * 查询单个角色
     *
     * @param roleId 主键
     * @return 角色
     */
    RoleDTO getRole(Long roleId);

    /**
     * 查询角色集合
     *
     * @return 角色集合
     */
    List<RoleDTO> listRoles();

    /**
     * 插入一条记录
     *
     * @param roleDTO 实体对象
     * @return 逻辑值
     */
    boolean saveRole(RoleDTO roleDTO);

    /**
     * 主键存在则更新记录，否则插入一条记录
     *
     * @param roleDTO 实体对象
     * @return 逻辑值
     */
    boolean saveOrUpdateRole(RoleDTO roleDTO);

    /**
     * 修改一条记录
     *
     * @param roleDTO 实体对象
     * @return 逻辑值
     */
    boolean updateRole(RoleDTO roleDTO);

    /**
     * 删除一条记录
     *
     * @param roleId 主键
     * @return 逻辑值
     */
    boolean deleteRole(Long roleId);
}
