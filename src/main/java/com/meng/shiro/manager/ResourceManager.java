/**
 * FileName: RoleManager
 * Author:   大橙子
 * Date:     2019/8/12 16:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.manager;

import com.meng.shiro.entity.dto.ResourceDTO;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/12
 * @since 1.0.0
 */
public interface ResourceManager {

    /**
     * 查询单个资源
     *
     * @param id 主键
     * @return 资源
     */
    ResourceDTO getResource(Long id);

    /**
     * 查询资源集合
     *
     * @return 资源集合
     */
    List<ResourceDTO> listResources();

    /**
     * 插入一条记录
     *
     * @param resourceDTO 实体对象
     * @return 逻辑值
     */
    boolean saveResource(ResourceDTO resourceDTO);

    /**
     * 主键存在则更新记录，否则插入一条记录
     *
     * @param resourceDTO 实体对象
     * @return 逻辑值
     */
    boolean saveOrUpdateResource(ResourceDTO resourceDTO);

    /**
     * 修改一条记录
     *
     * @param resourceDTO 实体对象
     * @return 逻辑值
     */
    boolean updateResource(ResourceDTO resourceDTO);

    /**
     * 删除一条记录
     *
     * @param id 主键
     * @return 逻辑值
     */
    boolean deleteResource(Long id);
}
