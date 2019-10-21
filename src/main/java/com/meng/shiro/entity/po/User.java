package com.meng.shiro.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 7838569805393187805L;
    /**
     * 主键
     */
    @TableId(value = "user_id")
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别(0:女 1:男 2:不详)
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 头像路径
     */
    private String photo;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;
    /**
     * 最后登陆时间
     */
    private String lastLoginTime;
    /**
     * 是否锁定(0:false 1:true)
     */
    @TableField("is_locked")
    private Boolean locked;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}