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

import com.meng.shiro.entity.dto.RoleDTO;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/12
 * @since 1.0.0
 */
public interface RoleManager {

    /**
     * 查询单个角色
     *
     * @param id 主键
     * @return 角色
     */
    RoleDTO getRole(Long id);

    /**
     * 查询角色集合
     *
     * @return 角色集合
     */
    List<RoleDTO> listRoles();

    /**
     * 插入一条记录
     *
     * @param roleDTO 实体对象
     * @return 逻辑值
     */
    boolean saveRole(RoleDTO roleDTO);

    /**
     * 主键存在则更新记录，否则插入一条记录
     *
     * @param roleDTO 实体对象
     * @return 逻辑值
     */
    boolean saveOrUpdateRole(RoleDTO roleDTO);

    /**
     * 修改一条记录
     *
     * @param roleDTO 实体对象
     * @return 逻辑值
     */
    boolean updateRole(RoleDTO roleDTO);

    /**
     * 删除一条记录
     *
     * @param id 主键
     * @return 逻辑值
     */
    boolean deleteRole(Long id);
}
