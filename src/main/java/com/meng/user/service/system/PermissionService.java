package com.meng.user.service.system;

import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.web.entity.PermissionQuery;

import java.util.List;

public interface PermissionService {

    PermissionDO getPermission(Long permissionId);

    List<PermissionDO> listPermissions();

    List<PermissionDO> listPermissions(PermissionQuery permissionQuery);

    void savePermission(PermissionDO permissionDODTO);

    void updatePermission(PermissionDO permissionDODTO);

    void deletePermission(Long permissionId);
}
