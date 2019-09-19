package com.meng.shiro.bean.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * AUTO             数据库自增
 * INPUT            自行输入
 * ID_WORKER        分布式全局唯一ID 长整型类型
 * UUID             32位UUID字符串
 * NONE             无状态
 * ID_WORKER_STR    分布式全局唯一ID 字符串类型
 * @author 大橙子
 *
 * @TableName(value = "sys_role", resultMap = "RoleResultMap")
 */
@Getter
@Setter
@ToString
@TableName(value = "sys_role")
public class RoleDO extends Model<RoleDO> {

    private static final long serialVersionUID = 80327963628797536L;
    /**
     * 主键
     */
    @TableId(value = "role_id")
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String comment;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 是否锁定
     */
    @TableField("is_locked")
    private Boolean locked;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}