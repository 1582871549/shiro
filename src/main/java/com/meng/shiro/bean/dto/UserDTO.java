package com.meng.shiro.bean.dto;

import com.meng.shiro.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = 3315228988741343381L;
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
     * 角色集合
     */
    private List<RoleDTO> roles;

}