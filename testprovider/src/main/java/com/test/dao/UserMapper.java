package com.test.dao;

import com.test.dao.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author liushaohua
 * @date 2018/4/3
 */

@Mapper
@Repository
public interface UserMapper {

     /**
      * 更新用户ID查询用户
      * @param id
      * @return
      */
     UserDo selectUserById(Long id);

     /**
      * 更新用户信息
      * @param userDo
      * @return
      */
     Boolean updateUser(UserDo userDo);
}
