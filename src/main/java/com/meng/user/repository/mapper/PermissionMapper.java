package com.meng.user.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.user.repository.entity.PermissionDO;
import com.meng.user.web.controller.entity.PermissionQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<PermissionDO> {

    /**
     * 查询资源集合
     *
     * @param permissionQuery 资源查询对象
     * @return 权限资源
     */
    List<PermissionDO> listPermissions(PermissionQuery permissionQuery);
}
