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

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meng.shiro.bean.dao.CopyDemo;
import com.meng.shiro.bean.dao.ResourceDO;
import com.meng.shiro.bean.dao.RoleDO;
import com.meng.shiro.bean.dto.RoleDTO;
import com.meng.shiro.dao.ResourceMapper;
import com.meng.shiro.dao.RoleMapper;
import com.meng.shiro.manager.RoleManager;
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
    public List<RoleDTO> listRole() {
        List<RoleDO> roleDOList = roleMapper.selectList(null);
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for (RoleDO roleDO : roleDOList) {
            RoleDTO roleDTO = new RoleDTO();
            CopyDemo.copyPropertiesIgnoreNull(roleDO, roleDTO);
            roleDTOList.add(roleDTO);
        }
        return roleDTOList;
    }

    @Override
    public List<RoleDTO> listRoleByUserId(String userId) {

        QueryWrapper<Object> wrapper = new QueryWrapper<>();
        List<ResourceDO> resourceDOList = resourceMapper.selectList(null);

        List<RoleDO> roleDOList = roleMapper.selectList(null);
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for (RoleDO roleDO : roleDOList) {
            RoleDTO roleDTO = new RoleDTO();
            CopyDemo.copyPropertiesIgnoreNull(roleDO, roleDTO);
            roleDTOList.add(roleDTO);
        }
        return null;
    }

    @Override
    public IPage<RoleDTO> listRoleByPage(IPage<RoleDTO> page, Wrapper<RoleDTO> queryWrapper) {
        return null;
    }

    @Override
    public int saveRole(RoleDTO roleDTO) {
        return 0;
    }

    @Override
    public int updateRole(RoleDTO roleDTO) {
        return 0;
    }

    @Override
    public int deleteRoleById(String roleId) {
        return 0;
    }

    @Override
    public int deleteRoleBatchByIds(List<String> idList) {
        return 0;
    }
}
