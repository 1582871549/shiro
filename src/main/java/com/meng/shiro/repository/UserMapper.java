package com.meng.shiro.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.shiro.entity.dto.UserDTO;
import com.meng.shiro.entity.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    Boolean getUserLocked(String username);

    IPage<UserDTO> listUsersByPage(Page<UserDTO> page);
}
