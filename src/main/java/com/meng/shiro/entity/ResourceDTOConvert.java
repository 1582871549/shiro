/**
 * FileName: DTOConvert
 * Author:   大橙子
 * Date:     2019/10/8 16:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.entity;

import com.meng.shiro.entity.dto.ResourceDTO;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.Resource;
import com.meng.shiro.entity.po.User;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/10/8
 * @since 1.0.0
 */
public interface ResourceDTOConvert extends Convert<ResourceDTO, Resource> {

    /**
     * 转换userDTO为userPO
     *
     * @param resourceDTO 用户传输类
     * @return 用户实体类
     */
    @Override
    default Resource doForward(ResourceDTO resourceDTO) {
        Resource resource = new Resource();
        copyPropertiesIgnoreNull(resourceDTO, resource);
        return resource;
    }

    /**
     * 转换userPO为userDTO
     *
     * @param resource 用户实体类
     * @return 用户传输类
     */
    @Override
    default ResourceDTO doBackward(Resource resource) {
        ResourceDTO resourceDTO = new ResourceDTO();
        copyPropertiesIgnoreNull(resource, resourceDTO);
        return resourceDTO;
    }

}
