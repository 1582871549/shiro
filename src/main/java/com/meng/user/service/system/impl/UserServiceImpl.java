package com.meng.user.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.user.common.exception.BusinessException;
import com.meng.user.common.util.BeanCopyUtil;
import com.meng.user.common.util.ResultUtil;
import com.meng.user.common.util.ShiroUtil;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.repository.mapper.UserMapper;
import com.meng.user.service.system.UserService;
import com.meng.user.service.system.entity.dto.UserDTO;
import com.meng.user.web.entity.request.UserReq;
import lombok.RequiredArgsConstructor;
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

    public String updatePassword(String password) {

        String salt = ShiroUtil.getRandomSalt(16);

        return ShiroUtil.sha256(password, salt);
    }

    @Override
    public void addCorrelationRoles(Long userId, Long... roleIds) {
        userMapper.addCorrelationRoles(userId, roleIds);
    }

    @Override
    public void removeCorrelationRoles(Long userId, Long... roleIds) {
        userMapper.removeCorrelationRoles(userId, roleIds);
    }

    @Override
    public void login(UserReq userReq) {

        String username = userReq.getUsername();
        String password = userReq.getPassword();

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
        } catch (AuthenticationException e) {
            throw new BusinessException("密码或用户名错误");
        }

        Session session = currentUser.getSession();

        session.setAttribute("username", username);
    }

    @Override
    public UserDTO getUser(Long userId) {
        UserDO userDO = userMapper.selectById(userId);
        return BeanCopyUtil.copy(userDO, UserDTO.class);
    }

    @Override
    public UserDTO getUser(String username) {
        UserDO userDO = userMapper.selectOne(new QueryWrapper<UserDO>().eq("username", username));
        return BeanCopyUtil.copy(userDO, UserDTO.class);
    }

    @Override
    public IPage<UserDO> listUsers(Page<UserDO> page) {
        return userMapper.selectPage(page, null);
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        UserDO userDO = BeanCopyUtil.copy(userDTO, UserDO.class);
        return ResultUtil.returnBool(userMapper.insert(userDO));
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
        UserDO userDO = BeanCopyUtil.copy(userDTO, UserDO.class);
        return ResultUtil.returnBool(userMapper.updateById(userDO));
    }

    @Override
    public boolean deleteUser(Long userId) {
        return ResultUtil.returnBool(userMapper.deleteById(userId));
    }


}
