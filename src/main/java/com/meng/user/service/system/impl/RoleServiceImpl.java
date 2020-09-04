package com.meng.user.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.user.common.enums.PermissionTypeEnum;
import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.repository.entity.RoleDO;
import com.meng.user.repository.mapper.RoleMapper;
import com.meng.user.service.system.PermissionService;
import com.meng.user.service.system.RoleService;
import com.meng.user.web.controller.entity.PermissionQuery;
import com.meng.user.web.controller.entity.RoleQuery;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private final PermissionService permissionService;

    @Override
    public RoleDO getRole(Long roleId) {
        return null;
    }

    @Override
    public RoleDO getRoleByRoleName(String roleName) {

        RoleDO roleDO = roleMapper.selectOne(new QueryWrapper<RoleDO>().eq("role_name", roleName));

        if (roleDO == null) {
            throw new RuntimeException();
        }

        return roleDO;
    }

    @Override
    public List<RoleDO> listRoles() {
        return null;
    }

    @Override
    public List<RoleDO> listRoles(RoleQuery roleQuery) {

        List<RoleDO> roleDOS = roleMapper.listRolesByUserId(roleQuery.getUserId());

        if (CollectionUtils.isEmpty(roleDOS)) {
            return Collections.emptyList();
        }

        return roleDOS;
    }

    @Override
    public void saveRole(RoleDO roleDO) {

    }

    @Override
    public void updateRole(RoleDO roleDO) {

    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public Set<String> listRoleNames(Long userId) {

        RoleQuery roleQuery = new RoleQuery();
        roleQuery.setUserId(userId);

        List<RoleDO> roleDOS = listRoles(roleQuery);

        if (CollectionUtils.isEmpty(roleDOS)) {
            return Collections.emptySet();
        }

        return roleDOS.stream()
                .map(RoleDO::getRoleName)
                .collect(Collectors.toSet());
    }

    /**
     * 获取角色相关的权限
     *
     * @param roleName 角色名称
     * @return 该角色拥有的权限
     */
    @Override
    public List<PermissionDO> listPermissions(String roleName) {

        RoleDO roleDO = getRoleByRoleName(roleName);

        PermissionQuery permissionQuery = new PermissionQuery();
        permissionQuery.setRoleId(roleDO.getRoleId());
        permissionQuery.setType(PermissionTypeEnum.BUTTON.getType());
        permissionQuery.setActivation(true);

        return permissionService.listPermissions(permissionQuery);
    }

}
