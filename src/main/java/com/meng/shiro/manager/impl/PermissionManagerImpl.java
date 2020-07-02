/**
 * FileName: RoleManagerImpl
 * Author:   大橙子
 * Date:     2019/8/12 16:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.manager.impl;

import com.meng.shiro.entity.dto.PermissionDTO;
import com.meng.shiro.entity.po.Permission;
import com.meng.shiro.manager.PermissionManager;
import com.meng.shiro.repository.PermissionMapper;
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
public class PermissionManagerImpl implements PermissionManager {

    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionManagerImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public PermissionDTO getPermission(Long permissionId) {
        return new PermissionDTO().doBackward(permissionMapper.selectById(permissionId));
    }

    @Override
    public List<PermissionDTO> listPermissions() {
        List<PermissionDTO> permissionDTOS = new ArrayList<>(200);
        for (Permission permission : permissionMapper.selectList(null)) {
            permissionDTOS.add(new PermissionDTO().doBackward(permission));
        }
        return permissionDTOS;
    }

    @Override
    public boolean savePermission(PermissionDTO permissionDTO) {
        return ResultUtil.returnBool(permissionMapper.insert(permissionDTO.doForward(permissionDTO)));
    }

    @Override
    public boolean saveOrUpdatePermission(PermissionDTO permissionDTO) {
        if (permissionDTO == null) {
            return false;
        }
        Long permissionId = permissionDTO.getPermissionId();
        return permissionId == null || getPermission(permissionId) == null ? savePermission(permissionDTO) : updatePermission(permissionDTO);
    }

    @Override
    public boolean updatePermission(PermissionDTO permissionDTO) {
        return ResultUtil.returnBool(permissionMapper.updateById(permissionDTO.doForward(permissionDTO)));
    }

    @Override
    public boolean deletePermission(Long id) {
        return ResultUtil.returnBool(permissionMapper.deleteById(id));
    }
}
