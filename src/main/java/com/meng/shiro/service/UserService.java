package com.meng.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.shiro.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    /**
     * 用户登录判断
     *
     * @param userDTO 用户信息
     */
    void login(UserDTO userDTO);

    /**
     * 查询单个用户
     *
     * @param id 主键
     * @return 用户
     */
    UserDTO getUser(Long id);

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
     * @param id 主键
     * @return 逻辑值
     */
    boolean deleteUser(Long id);
}
