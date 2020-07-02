package com.meng.shiro.service.impl;

import com.meng.shiro.entity.dto.PermissionDTO;
import com.meng.shiro.manager.PermissionManager;
import com.meng.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mengli
 * @create 2019/12/24
 * @since 1.0.0
 */
@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionManager permissionManager;

    @Autowired
    public PermissionServiceImpl(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    @Override
    public PermissionDTO getPermission(Long permissionId) {
        return permissionManager.getPermission(permissionId);
    }

    @Override
    public List<PermissionDTO> listPermissions() {
        return permissionManager.listPermissions();
    }

    @Override
    public boolean savePermission(PermissionDTO permissionDTO) {
        return permissionManager.savePermission(permissionDTO);
    }

    @Override
    public boolean saveOrUpdatePermission(PermissionDTO permissionDTO) {
        return permissionManager.saveOrUpdatePermission(permissionDTO);
    }

    @Override
    public boolean updatePermission(PermissionDTO permissionDTO) {
        return permissionManager.updatePermission(permissionDTO);
    }

    @Override
    public boolean deletePermission(Long permissionId) {
        return permissionManager.deletePermission(permissionId);
    }
}
