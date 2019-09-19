/**
 * FileName: RoleService
 * Author:   大橙子
 * Date:     2019/8/8 10:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meng.shiro.bean.dto.RoleDTO;
import com.meng.shiro.manager.RoleManager;
import com.meng.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/8
 * @since 1.0.0
 */

@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleManager roleManager;

    @Autowired
    public RoleServiceImpl(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @Override
    public List<RoleDTO> listRole() {
        return roleManager.listRole();
    }

    @Override
    public List<RoleDTO> listRoleByUserId(String userId) {
        return roleManager.listRoleByUserId(userId);
    }

    @Override
    public IPage<RoleDTO> listRoleByPage(IPage<RoleDTO> page, Wrapper<RoleDTO> queryWrapper) {
        return roleManager.listRoleByPage(page, queryWrapper);
    }

    @Override
    public int saveRole(RoleDTO roleDTO) {
        return roleManager.saveRole(roleDTO);
    }

    @Override
    public int updateRole(RoleDTO roleDTO) {
        return roleManager.updateRole(roleDTO);
    }

    @Override
    public int deleteRoleById(String roleId) {
        return roleManager.deleteRoleById(roleId);
    }

    @Override
    public int deleteRoleBatchByIds(List<String> idList) {
        return roleManager.deleteRoleBatchByIds(idList);
    }
}
