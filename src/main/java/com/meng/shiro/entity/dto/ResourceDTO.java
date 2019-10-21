package com.meng.shiro.entity.dto;

import com.meng.shiro.base.BaseDTO;
import com.meng.shiro.entity.ResourceDTOConvert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 大橙子
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResourceDTO extends BaseDTO implements ResourceDTOConvert {

    private static final long serialVersionUID = 7225989106023399374L;
    /**
     * 资源id
     */
    private Long resourceId;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 描述
     */
    private String comment;
    /**
     * 类型
     */
    private Integer type;
    /**
     * url
     */
    private String url;
    /**
     * 操作
     */
    private String operation;
    /**
     * 父元素id
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标
     */
    private String icon;
}