package com.meng.user.service.system.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author 大橙子
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends BaseDTO {

    private static final long serialVersionUID = -8532970873838122778L;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 资源集合
     */
    private List<PermissionDTO> permissions;
    /**
     * 是否可用(0:false 1:true)
     */
    private Boolean activation = Boolean.FALSE;
}