package com.test.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.api.dto.UserDTO;
import com.test.api.service.UserDubboService;
import com.test.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author liushaohua
 * @date 2018/6/27
 */
@Service(version = "local_jiangbei",interfaceClass = UserDubboService.class)
public class UserDubboServiceImpl implements UserDubboService {

    @Autowired
    private UserServiceI userServiceI;

    @Override
    public UserDTO getUserByUserId(Long id) {
        return userServiceI.getUserByUserId(id);
    }
}
