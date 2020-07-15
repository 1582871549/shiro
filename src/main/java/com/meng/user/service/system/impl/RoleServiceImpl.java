package com.meng.user.service.system.impl;

import com.meng.user.common.util.ResultUtil;
import com.meng.user.repository.entity.Role;
import com.meng.user.repository.mapper.RoleMapper;
import com.meng.user.service.system.entity.dto.RoleDTO;
import com.meng.user.service.system.RoleService;

import lombok.RequiredArgsConstructor;
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
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public void addCorrelationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public void removeCorrelationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public RoleDTO getRole(Long roleId) {

        Role role = roleMapper.selectById(roleId);

        return null;
    }

    @Override
    public List<RoleDTO> listRoles() {

        List<Role> roles = roleMapper.selectList(null);

        return null;
    }

    @Override
    public boolean saveRole(RoleDTO roleDTO) {
        return ResultUtil.returnBool(roleMapper.insert(null));
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
        return ResultUtil.returnBool(roleMapper.updateById(null));
    }

    @Override
    public boolean deleteRole(Long roleId) {
        return ResultUtil.returnBool(roleMapper.deleteById(null));
    }
}
