package com.meng.user.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.user.common.exception.BusinessException;
import com.meng.user.common.util.ResultUtil;
import com.meng.user.repository.entity.User;
import com.meng.user.repository.mapper.UserMapper;
import com.meng.user.service.system.UserService;
import com.meng.user.service.system.entity.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public void addCorrelationRoles(Long userId, Long... roleIds) {
        userMapper.addCorrelationRoles(userId, roleIds);
    }

    @Override
    public void removeCorrelationRoles(Long userId, Long... roleIds) {
        userMapper.removeCorrelationRoles(userId, roleIds);
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
        if (userMapper.getUserLocked(username)) {
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
    public UserDTO getUser(Long userId) {
        User user = userMapper.selectById(userId);
        return null;
    }

    @Override
    public UserDTO getUser(String username) {

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));

        return null;
    }

    @Override
    public IPage<UserDTO> listUsers(Page<UserDTO> page) {

        Page<User> userPage = new Page<>();

        IPage<User> userIPage = userMapper.selectPage(userPage, null);

        return null;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return ResultUtil.returnBool(userMapper.insert(null));
    }

    @Override
    public boolean saveOrUpdateUser(UserDTO userDTO) {
        if (userDTO == null) {
            return false;
        }
        Long userId = userDTO.getUserId();
        return userId == null || getUser(userId) == null ? saveUser(userDTO) : updateUser(userDTO);
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return ResultUtil.returnBool(userMapper.updateById(null));
    }

    @Override
    public boolean deleteUser(Long userId) {
        return ResultUtil.returnBool(userMapper.deleteById(userId));
    }


}
