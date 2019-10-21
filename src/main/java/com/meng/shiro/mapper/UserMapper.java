package com.meng.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.shiro.entity.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    Boolean getUserLocked(String username);
}
