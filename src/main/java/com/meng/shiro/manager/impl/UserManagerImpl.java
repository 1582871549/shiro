package com.meng.shiro.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;
import com.meng.shiro.manager.UserManager;
import com.meng.shiro.repository.UserMapper;
import com.meng.shiro.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author mengli
 * @create 2019/12/24
 * @since 1.0.0
 */
@Component
public class UserManagerImpl implements UserManager {

    private final UserMapper userMapper;

    @Autowired
    public UserManagerImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addCorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void removeCorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public Set<RoleDTO> getRoles(String username) {
        return null;
    }

    @Override
    public UserDTO getUser(Long userId) {
        return new UserDTO().doBackward(userMapper.selectById(userId));
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

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     */
    public IPage<UserDTO> listUsers(Page<UserDTO> page) {
        return userMapper.listUsersByPage(page);
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
    public boolean deleteUser(Long userId) {
        return ResultUtil.returnBool(userMapper.deleteById(userId));
    }

    @Override
    public boolean getUserLocked(String username) {
        return userMapper.getUserLocked(username);
    }
}
