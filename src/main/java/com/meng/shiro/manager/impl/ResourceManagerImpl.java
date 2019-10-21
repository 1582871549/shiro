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

import com.meng.shiro.entity.dto.ResourceDTO;
import com.meng.shiro.entity.dto.RoleDTO;
import com.meng.shiro.entity.po.Resource;
import com.meng.shiro.entity.po.Role;
import com.meng.shiro.manager.ResourceManager;
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

@Component("resourceManagerImpl")
public class ResourceManagerImpl implements ResourceManager {

    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceManagerImpl(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    @Override
    public ResourceDTO getResource(Long id) {
        return new ResourceDTO().doBackward(resourceMapper.selectById(id));
    }

    @Override
    public List<ResourceDTO> listResources() {
        List<ResourceDTO> resourceDTOS = new ArrayList<>(200);
        for (Resource resource : resourceMapper.selectList(null)) {
            resourceDTOS.add(new ResourceDTO().doBackward(resource));
        }
        return resourceDTOS;
    }

    @Override
    public boolean saveResource(ResourceDTO resourceDTO) {
        return ResultUtil.returnBool(resourceMapper.insert(resourceDTO.doForward(resourceDTO)));
    }

    @Override
    public boolean saveOrUpdateResource(ResourceDTO resourceDTO) {
        if (resourceDTO == null) {
            return false;
        }
        Long resourceId = resourceDTO.getResourceId();
        return resourceId == null || getResource(resourceId) == null ? saveResource(resourceDTO) : updateResource(resourceDTO);
    }

    @Override
    public boolean updateResource(ResourceDTO resourceDTO) {
        return ResultUtil.returnBool(resourceMapper.updateById(resourceDTO.doForward(resourceDTO)));
    }

    @Override
    public boolean deleteResource(Long id) {
        return ResultUtil.returnBool(resourceMapper.deleteById(id));
    }
}
