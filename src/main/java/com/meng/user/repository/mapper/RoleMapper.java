package com.meng.user.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.user.repository.entity.RoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<RoleDO> {

    /**
     * 通过用户id查询用户所拥有的所有角色
     *
     * @param userId 用户id
     * @return 角色集合
     */
    List<RoleDO> listRolesByUserId(Long userId);

}
