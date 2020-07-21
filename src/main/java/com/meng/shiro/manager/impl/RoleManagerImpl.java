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

import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.po.Role;
import com.meng.shiro.manager.RoleManager;
import com.meng.shiro.mapper.ResourceMapper;
import com.meng.shiro.mapper.RoleMapper;
import com.meng.shiro.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/12
 * @since 1.0.0
 */

@Component("roleManagerImpl")
public class RoleManagerImpl implements RoleManager {

    private final RoleMapper roleMapper;

    private final ResourceMapper resourceMapper;

    @Autowired
    public RoleManagerImpl(RoleMapper roleMapper, ResourceMapper resourceMapper) {
        this.roleMapper = roleMapper;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public RoleDTO getRole(Long id) {
        return new RoleDTO().doBackward(roleMapper.selectById(id));
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
    public boolean deleteRole(Long id) {
        return ResultUtil.returnBool(roleMapper.deleteById(id));
    }
}
