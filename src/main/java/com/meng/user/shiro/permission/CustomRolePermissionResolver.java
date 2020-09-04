package com.meng.user.shiro.permission;

import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.service.system.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 如果Realm进行授权的话，应该继承AuthorizingRealm，其流程是：
 *
 * 1.1、如果调用hasRole*，则直接获取AuthorizationInfo.getRoles()与传入的角色比较即可；
 *
 * 1.2、首先如果调用如isPermitted(“user:view”)，
 *      首先通过PermissionResolver将权限字符串转换成相应的Permission实例，
 *      默认使用WildcardPermissionResolver，即转换为通配符的WildcardPermission；
 *
 * 2、通过AuthorizationInfo.getObjectPermissions()得到Permission实例集合；
 *      通过AuthorizationInfo. getStringPermissions()得到字符串集合
 *      并通过PermissionResolver解析为Permission实例；
 *      然后获取用户的角色，并通过RolePermissionResolver解析角色对应的权限集合（默认没有实现，可以自己提供）；
 *
 * 3、接着调用Permission. implies(PermissionDO p)逐个与传入的权限比较，如果有匹配的则返回true，否则false。
 */
public class CustomRolePermissionResolver implements RolePermissionResolver {

    @Autowired
    private RoleService roleService;

    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleName) {

        Set<String> permissionUrls = getPermissions(roleName);
        Set<Permission> permissions = new LinkedHashSet<>(permissionUrls.size());

        for (String permissionUrl : permissionUrls) {
            permissions.add(new WildcardPermission(permissionUrl));
        }

        return permissions;
    }

    private Set<String> getPermissions(String roleName) {

        List<PermissionDO> permissions = roleService.listPermissions(roleName);

        Set<String> perms = new LinkedHashSet<>(permissions.size());

        for (PermissionDO permission : permissions) {

            String operation = permission.getOperation();

            if (StringUtils.isNotBlank(operation)) {
                perms.add(operation);
            }
        }

        return perms;
    }

}
