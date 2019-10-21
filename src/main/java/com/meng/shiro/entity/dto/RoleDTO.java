package com.meng.shiro.entity.dto;

import com.meng.shiro.base.BaseDTO;
import com.meng.shiro.entity.RoleDTOConvert;
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
public class RoleDTO extends BaseDTO implements RoleDTOConvert {

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
    private String comment;
    /**
     * 资源集合
     */
    private List<ResourceDTO> resources;
}