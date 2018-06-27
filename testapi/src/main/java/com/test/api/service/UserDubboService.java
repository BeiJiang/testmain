package com.test.api.service;


import com.test.api.dto.UserDTO;

/**
 *
 * @author liushaohua
 * @date 2018/6/22
 */
public interface UserDubboService {

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    UserDTO getUserByUserId(Long id);
}
