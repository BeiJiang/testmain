package com.test.web;


import com.test.utils.RedisUtil;
import com.test.dao.entity.UserDo;
import com.test.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author liushaohua
 * @date 2018/4/3
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserServiceI userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "getUser.json", method = RequestMethod.GET)
    @ResponseBody
    public UserDo getUserById(@RequestParam(name = "id") Long id){
        try {
            Object o = redisUtil.get(id.toString());
            if(null != o){
                UserDo userDo = (UserDo) o;
                return userDo;
            }
            return userService.selectUserById(id);
        }catch (Exception e){
           e.printStackTrace();
        }
        return null;
    }
}
