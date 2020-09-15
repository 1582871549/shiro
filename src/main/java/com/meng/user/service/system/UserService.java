package com.meng.user.service.system;

import com.meng.user.repository.entity.UserDO;

import java.util.List;

public interface UserService {

    UserDO getUser(Long userId);

    UserDO getUserByUsername(String username);

    List<UserDO> listUsers();

    void saveUser(UserDO userDO);

    void updateUser(UserDO userDO);

    void deleteUser(UserDO userDO);


    /**
     * 修改密码
     *
     * @param userDO 用户id, 新密码
     */
    void updatePassword(UserDO userDO);

    /**
     * 密码加密
     *
     * @param origPassword 原始密码
     * @param salt 盐
     * @return encrPassword 加密密码
     */
    String encryption(String origPassword, String salt);

    String login(UserDO userDO);
}
