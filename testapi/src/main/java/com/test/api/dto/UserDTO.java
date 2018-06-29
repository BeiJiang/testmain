package com.test.api.dto;


import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author liushaohua
 * @date 2018/6/22
 */
@Data
public class UserDTO implements Serializable{
    private Long id;

    private String name;

    private String sex;
}
