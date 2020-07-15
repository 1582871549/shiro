package com.meng.user.repository.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 大橙子
 * @create 2019/3/25
 * @since 1.0.0
 */

@Data
public abstract class BaseDO implements Serializable {

    private static final long serialVersionUID = 8834558783211988412L;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;
}
