package com.meng.user.service.system;

import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.repository.entity.RoleDO;
import com.meng.user.web.entity.RoleQuery;

import java.util.List;
import java.util.Set;

public interface RoleService {

    RoleDO getRole(Long roleId);

    RoleDO getRoleByRoleName(String roleName);

    List<RoleDO> listRoles();

    List<RoleDO> listRoles(RoleQuery roleQuery);

    void saveRole(RoleDO roleDO);

    void updateRole(RoleDO roleDO);

    void deleteRole(Long roleId);



    Set<String> listRoleNames(Long userId);

    List<PermissionDO> listPermissions(String roleName);
}
