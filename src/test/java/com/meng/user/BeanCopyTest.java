package com.meng.user;

import com.meng.user.common.util.BeanUtil;
import com.meng.user.repository.entity.UserDO;
import com.meng.user.service.system.entity.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanCopyTest {

    @Test
    public void aa() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("root");
        userDTO.setPassword("dudu");

        UserDO copy = BeanUtil.copy(userDTO, UserDO.class);

        System.out.println(copy);

    }

}
