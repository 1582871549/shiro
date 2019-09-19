package com.meng.shiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.shiro.bean.dao.UserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    Boolean getUserLocked(String username);
}
