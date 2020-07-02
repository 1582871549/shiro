package com.meng.shiro.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.exception.BusinessException;
import com.meng.shiro.manager.UserManager;
import com.meng.shiro.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author 大橙子
 * @create 2019/8/8
 * @since 1.0.0
 */
@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    private final UserManager userManager;

    @Autowired
    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addCorrelationRoles(Long userId, Long... roleIds) {
        userManager.addCorrelationRoles(userId, roleIds);
    }

    @Override
    public void removeCorrelationRoles(Long userId, Long... roleIds) {
        userManager.removeCorrelationRoles(userId, roleIds);
    }

    @Override
    public void login(UserDTO userDTO) {

        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        // 检查空值
        if (StringUtils.isBlank(username)) {
            throw new BusinessException("username can't be empty");
        }
        if (StringUtils.isBlank(password)) {
            throw new BusinessException("password can't be empty");
        }

        // 检查用户状态
        if (userManager.getUserLocked(username)) {
            throw new BusinessException("该用户已锁定");
        }

        Subject currentUser = SecurityUtils.getSubject();

        if (currentUser.isAuthenticated()) {
            return;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            currentUser.login(token);

            Session session = currentUser.getSession();

            session.setAttribute("username", username);

        } catch (AuthenticationException e) {
            throw new BusinessException("密码或用户名错误");
        }
    }

    @Override
    public Set<RoleDTO> getRoles(String username) {
        return userManager.getRoles(username);
    }

    @Override
    public UserDTO getUser(Long userId) {
        return userManager.getUser(userId);
    }

    @Override
    public UserDTO getUser(String username) {
        return userManager.getUser(username);
    }

    @Override
    public IPage<UserDTO> listUsers(Page<UserDTO> page) {
        return userManager.listUsers(page);
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return userManager.saveUser(userDTO);
    }

    @Override
    public boolean saveOrUpdateUser(UserDTO userDTO) {
        return userManager.saveOrUpdateUser(userDTO);
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userManager.updateUser(userDTO);
    }

    @Override
    public boolean deleteUser(Long userId) {
        return userManager.deleteUser(userId);
    }


}
