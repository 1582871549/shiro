package com.meng.shiro.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meng.shiro.bean.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有角色
     *
     * @return userList
     */
    List<RoleDTO> listRole();

    /**
     * 查询用户对应的角色列表
     *
     * @return userList
     */
    List<RoleDTO> listRoleByUserId(String userId);

    /**
     * 根据 entity 条件，查询全部记录 (并分页)
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return 分页对象
     */
    IPage<RoleDTO> listRoleByPage(IPage<RoleDTO> page, Wrapper<RoleDTO> queryWrapper);

    /**
     * 插入一条记录
     *
     * @param roleDTO 角色实体类
     * @return 主键
     */
    int saveRole(RoleDTO roleDTO);

    /**
     * 修改记录
     *
     * @param roleDTO 角色实体类
     * @return 主键
     */
    int updateRole(RoleDTO roleDTO);

    /**
     * 删除一条记录
     *
     * @param roleId 主键ID
     * @return 主键
     */
    int deleteRoleById(String roleId);

    /**
     * 批量删除记录
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     * @return 删除成功记录数
     */
    int deleteRoleBatchByIds(List<String> idList);
}
