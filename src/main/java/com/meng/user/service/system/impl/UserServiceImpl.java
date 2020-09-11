package com.meng.user.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.user.common.util.ShiroHelper;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.repository.mapper.UserMapper;
import com.meng.user.service.system.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 大橙子
 * @create 2019/8/8
 * @since 1.0.0
 */
@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final ShiroHelper shiroHelper;

    @Override
    public UserDO getUser(Long userId) {
        return null;
    }

    @Override
    public UserDO getUserByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<UserDO>().eq("username", username));
    }

    @Override
    public List<UserDO> listUsers() {
        return null;
    }

    @Override
    public void saveUser(UserDO userDO) {

    }

    @Override
    public void updateUser(UserDO userDO) {

    }

    @Override
    public void deleteUser(UserDO userDO) {

    }

    @Override
    public String updatePassword(String password) {

        String salt = ShiroHelper.getRandomSalt(16);

        return "";
    }

    /**
     * 使用加密算法对密码进行加密
     *
     * @param password 密码
     * @param salt 盐
     * @return 加密后的密码
     */
    public String encryptionPassword(String password, String salt) {
        return shiroHelper.sha256(password, salt);
    }

    @Override
    public void login(UserDO userDO) {
        String username = userDO.getUsername();
        String password = userDO.getPassword();

        // 检查用户状态
        // if (userMapper.getUserLocked(username)) {
        //     throw new BusinessException("该用户已锁定");
        // }

        Subject currentUser = SecurityUtils.getSubject();

        if (currentUser.isAuthenticated()) {
            return;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            // throw new BusinessException("密码或用户名错误");
        }

        Session session = currentUser.getSession();

        session.setAttribute("username", username);
    }

}
