package com.meng.user.web.controller.entity;

import lombok.Data;

/**
 * 角色查询
 */
@Data
public class RoleQuery {

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 是否可用(0:false 1:true)
     */
    private Boolean activation;
}