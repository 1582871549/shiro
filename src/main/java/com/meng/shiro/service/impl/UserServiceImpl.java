/**
 * FileName: UserServiceImpl
 * Author:   大橙子
 * Date:     2019/8/8 10:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;
import com.meng.shiro.exception.BusinessException;
import com.meng.shiro.mapper.UserMapper;
import com.meng.shiro.util.ResultUtil;
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

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/8
 * @since 1.0.0
 */

@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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

        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

        // 2、判断当前用户是否登录
        if (!currentUser.isAuthenticated()) {
            // 3、将用户名和密码封装到UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            // 4、认证
            try {
                currentUser.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
                Session session = currentUser.getSession();
                session.setAttribute("username", username);
            } catch (AuthenticationException e) {
                throw new BusinessException("密码或用户名错误");
            }
        }
    }

    @Override
    public UserDTO getUser(Long id) {
        return new UserDTO().doBackward(userMapper.selectById(id));
    }

    @Override
    public UserDTO getUser(String username) {
        return new UserDTO().doBackward(userMapper.selectOne(new QueryWrapper<User>().eq("username", username)));
    }

    @Override
    public List<UserDTO> listUsers() {
        List<UserDTO> userDTOS = new ArrayList<>(200);
        for (User user : userMapper.selectList(null)) {
            userDTOS.add(new UserDTO().doBackward(user));
        }
        return userDTOS;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return ResultUtil.returnBool(userMapper.insert(userDTO.doForward(userDTO)));
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
        return ResultUtil.returnBool(userMapper.updateById(userDTO.doForward(userDTO)));
    }

    @Override
    public boolean deleteUser(Long id) {
        return ResultUtil.returnBool(userMapper.deleteById(id));
    }


}
