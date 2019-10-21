package com.meng.shiro.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 大橙子
 */
@Getter
@Setter
@ToString
@TableName("sys_resource")
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = -3734186975559806202L;
    /**
     * 主键
     */
    @TableId(value = "resource_id")
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
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;
    /**
     * 是否锁定
     */
    @TableField("is_locked")
    private Boolean locked;

    @Override
    protected Serializable pkVal() {
        return this.resourceId;
    }
}