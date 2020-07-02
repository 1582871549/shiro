package com.meng.shiro.manager.impl;

import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.po.Role;
import com.meng.shiro.manager.RoleManager;
import com.meng.shiro.repository.PermissionMapper;
import com.meng.shiro.repository.RoleMapper;
import com.meng.shiro.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大橙子
 * @create 2019/8/12
 * @since 1.0.0
 */
@Component
public class RoleManagerImpl implements RoleManager {

    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;

    @Autowired
    public RoleManagerImpl(RoleMapper roleMapper, PermissionMapper permissionMapper) {
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public void addCorrelationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public void removeCorrelationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public RoleDTO getRole(Long roleId) {
        return new RoleDTO().doBackward(roleMapper.selectById(roleId));
    }

    @Override
    public List<RoleDTO> listRoles() {
        List<RoleDTO> roleDTOS = new ArrayList<>(200);
        for (Role role : roleMapper.selectList(null)) {
            roleDTOS.add(new RoleDTO().doBackward(role));
        }
        return roleDTOS;
    }

    @Override
    public boolean saveRole(RoleDTO roleDTO) {
        return ResultUtil.returnBool(roleMapper.insert(roleDTO.doForward(roleDTO)));
    }

    @Override
    public boolean saveOrUpdateRole(RoleDTO roleDTO) {
        if (roleDTO == null) {
            return false;
        }
        Long roleId = roleDTO.getRoleId();
        return roleId == null || getRole(roleId) == null ? saveRole(roleDTO) : updateRole(roleDTO);
    }

    @Override
    public boolean updateRole(RoleDTO roleDTO) {
        return ResultUtil.returnBool(roleMapper.updateById(roleDTO.doForward(roleDTO)));
    }

    @Override
    public boolean deleteRole(Long roleId) {
        return ResultUtil.returnBool(roleMapper.deleteById(roleId));
    }
}
