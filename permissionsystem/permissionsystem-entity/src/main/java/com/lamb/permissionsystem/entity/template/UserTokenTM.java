package com.lamb.permissionsystem.entity.template;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户token-redis模板
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:56
 **/
@Data
public class UserTokenTM implements Serializable{

    private Integer userId;

    private String accessToken;
}
