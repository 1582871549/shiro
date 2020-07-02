package com.meng.shiro.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.dto.UserDTO;

import java.util.List;
import java.util.Set;

public interface UserManager {

    /**
     * 添加用户-角色之间关系
     *
     * @param userId 用户id
     * @param roleIds 角色ids
     */
    void addCorrelationRoles(Long userId, Long... roleIds);

    /**
     * 移除用户-角色之间关系
     *
     * @param userId 用户id
     * @param roleIds 角色ids
     */
    void removeCorrelationRoles(Long userId, Long... roleIds);

    /**
     * 获取用户对应的角色集合
     *
     * @param username 用户名
     * @return 角色
     */
    Set<RoleDTO> getRoles(String username);

    /**
     * 查询单个用户
     *
     * @param userId 主键
     * @return 用户
     */
    UserDTO getUser(Long userId);

    /**
     * 查询单个用户
     *
     * @param username 用户名
     * @return 用户
     */
    UserDTO getUser(String username);

    /**
     * 查询用户集合
     *
     * @return 用户集合
     */
    List<UserDTO> listUsers();

    IPage<UserDTO> listUsers(Page<UserDTO> page);

    /**
     * 插入一条记录
     *
     * @param userDTO 实体对象
     * @return 逻辑值
     */
    boolean saveUser(UserDTO userDTO);

    /**
     * 主键存在则更新记录，否则插入一条记录
     *
     * @param userDTO 实体对象
     * @return 逻辑值
     */
    boolean saveOrUpdateUser(UserDTO userDTO);

    /**
     * 修改一条记录
     *
     * @param userDTO 实体对象
     * @return 逻辑值
     */
    boolean updateUser(UserDTO userDTO);

    /**
     * 删除一条记录
     *
     * @param userId 主键
     * @return 逻辑值
     */
    boolean deleteUser(Long userId);

    /**
     * 获取用户锁定状态
     * @param username 用户名
     * @return 是否锁定
     */
    boolean getUserLocked(String username);
}
