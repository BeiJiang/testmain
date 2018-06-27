package com.test.service;


import com.test.api.dto.UserDTO;
import com.test.dao.entity.UserDo;

/**
 * @author liushaohua
 * @date 2018/4/4
 */
public interface UserServiceI {

    /**
     * 用户ID查询用户
     *
     * @param id
     * @return
     */
    UserDo selectUserById(Long id);

    /**
     * 更新用户信息
     *
     * @param userDo
     * @return
     */
    Boolean updateUser(UserDo userDo);

    /**
     * 用户ID查询用户
     * @param id
     * @return
     */
    UserDTO getUserByUserId(Long id);
}
