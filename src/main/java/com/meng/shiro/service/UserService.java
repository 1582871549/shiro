package com.meng.shiro.service;

import com.meng.shiro.bean.dto.UserDTO;

public interface UserService extends BaseService<UserDTO> {



    /**
     * 根据账号查询用户
     *
     * @param username 用户名
     * @return user
     */
    UserDTO getUserByUsername(String username);

    void login(UserDTO userDTO);
}
