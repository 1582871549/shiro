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

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meng.shiro.bean.dao.CopyDemo;
import com.meng.shiro.bean.dao.UserDO;
import com.meng.shiro.bean.dto.UserDTO;
import com.meng.shiro.dao.UserMapper;
import com.meng.shiro.exception.BusinessException;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    public UserDTO getById(long id) {
        UserDTO userDTO = new UserDTO();
        UserDO userDO = userMapper.selectById(id);
        CopyDemo.copyPropertiesIgnoreNull(userDO, userDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> list() {
        List<UserDO> userDOList = userMapper.selectList(null);
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserDO userDO : userDOList) {
            UserDTO userDTO = new UserDTO();
            CopyDemo.copyPropertiesIgnoreNull(userDO, userDTO);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public IPage<UserDTO> listByPage(IPage<UserDTO> page, Wrapper<UserDTO> queryWrapper) {
        return null;
    }

    @Override
    public long insert(UserDTO entity) {
        return 0;
    }

    @Override
    public int update(UserDTO entity) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> ids) {
        return 0;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
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



}
