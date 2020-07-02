package com.meng.shiro.entity.vo;

import com.meng.shiro.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IndexUserVO extends BaseVO {

    private static final long serialVersionUID = -6923768443982647649L;
    /**
     * 用户id
     */
    private String userId;
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
     * 手机号
     */
    private String phone;
    /**
     * 头像路径
     */
    private String photo;
    /**
     * 性别(0:女 1:男 2:不详)
     */
    private String sex;
    /**
     * 最后登陆时间
     */
    private String lastTime;
    /**
     * 是否锁定(0:false 1:true)
     */
    private Boolean locked = Boolean.FALSE;
}