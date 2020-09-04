package com.meng.user.service.system.impl;

import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.repository.mapper.PermissionMapper;
import com.meng.user.service.system.PermissionService;
import com.meng.user.web.controller.entity.PermissionQuery;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author mengli
 * @create 2019/12/24
 * @since 1.0.0
 */
@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    @Override
    public PermissionDO getPermission(Long permissionId) {
        return null;
    }

    @Override
    public List<PermissionDO> listPermissions() {
        return null;
    }

    @Override
    public List<PermissionDO> listPermissions(PermissionQuery permissionQuery) {

        List<PermissionDO> permissionDOS = permissionMapper.listPermissions(permissionQuery);

        if (CollectionUtils.isEmpty(permissionDOS)) {
            return Collections.emptyList();
        }

        return permissionDOS;
    }

    @Override
    public void savePermission(PermissionDO permissionDODTO) {

    }

    @Override
    public void updatePermission(PermissionDO permissionDODTO) {

    }

    @Override
    public void deletePermission(Long permissionId) {

    }
}
