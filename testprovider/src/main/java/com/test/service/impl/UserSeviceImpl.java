package com.test.service.impl;


import com.test.Utils.RedisUtil;
import com.test.api.dto.UserDTO;
import com.test.dao.UserMapper;
import com.test.dao.entity.UserDo;
import com.test.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liushaohua
 * @date 2018/4/4
 */
@Slf4j
@Service
class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserDo selectUserById(Long id) {
        if(null == id){
            return null;
        }
        log.info("selectUserById,id="+id);
        UserDo userDo = userMapper.selectUserById(id);
        redisUtil.set(id.toString(),userDo);
        return userDo;
    }

    @Override
    public Boolean updateUser(UserDo userDo) {
        if(null == userDo || null == userDo.getId()){
            return false;
        }

        return true;
    }

    @Override
    public UserDTO getUserByUserId(Long id) {
        if(null == id){
            return null;
        }
        log.info("getUserByUserId,id="+id);
        UserDo userDo = userMapper.selectUserById(id);
        redisUtil.set(id.toString(),userDo);
        return convertUserDoToDTO(userDo);
    }

    /**
     *
     * @param userDo
     * @return
     */
    private UserDTO convertUserDoToDTO(UserDo userDo){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDo,userDTO);
        return userDTO;
    }
}
