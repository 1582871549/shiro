package com.meng.user.service.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.user.service.system.entity.dto.UserDTO;

import java.util.Set;

public interface UserService {

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
     * 用户登录判断
     *
     * @param userDTO 用户信息
     */
    void login(UserDTO userDTO);

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
     * @param page 分页对象
     * @return 用户集合
     */
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
}
