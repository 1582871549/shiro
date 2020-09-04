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



    String updatePassword(String password);

    void login(UserDO userDO);
}
