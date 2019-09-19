package com.meng.shiro.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 基础接口
 *
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    T getById(long id);

    /**
     * 查询全部记录
     */
    List<T> list();

    /**
     * 根据 entity 条件，查询全部记录 (并分页)
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    IPage<T> listByPage(IPage<T> page, Wrapper<T> queryWrapper);

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     */
    long insert(T entity);

    /**
     * 根据 ID 修改
     *
     * @param entity 实体对象
     */
    int update(T entity);

    /**
     * 根据 ID 删除
     *
     * @param id 主键
     */
    int delete(long id);

    /**
     * 批量删除记录
     *
     * @param ids 主键ID列表(不能为 null 以及 empty)
     * @return 删除成功记录数
     */
    int deleteBatchIds(Collection<? extends Serializable> ids);
}
