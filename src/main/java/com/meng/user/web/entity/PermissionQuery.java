package com.meng.user.web.entity;

import lombok.Data;

/**
 * 资源查询
 */
@Data
public class PermissionQuery {

    /**
     * 资源id
     */
    private Long permissionId;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 类型（0：目录，1：菜单，2：按钮）
     */
    private Integer type;
    /**
     * 是否可用(0:false 1:true)
     */
    private Boolean activation;
}