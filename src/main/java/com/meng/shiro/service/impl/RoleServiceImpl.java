package com.meng.shiro.service.impl;

import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.manager.RoleManager;
import com.meng.shiro.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleServiceImpl implements RoleService {

    private final RoleManager roleManager;

    @Autowired
    public RoleServiceImpl(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @Override
    public void addCorrelationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public void removeCorrelationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public RoleDTO getRole(Long roleId) {
        return roleManager.getRole(roleId);
    }

    @Override
    public List<RoleDTO> listRoles() {
        return roleManager.listRoles();
    }

    @Override
    public boolean saveRole(RoleDTO roleDTO) {
        return roleManager.saveRole(roleDTO);
    }

    @Override
    public boolean saveOrUpdateRole(RoleDTO roleDTO) {
        return roleManager.saveOrUpdateRole(roleDTO);
    }

    @Override
    public boolean updateRole(RoleDTO roleDTO) {
        return roleManager.updateRole(roleDTO);
    }

    @Override
    public boolean deleteRole(Long roleId) {
        return roleManager.deleteRole(roleId);
    }
}
