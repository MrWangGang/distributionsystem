package com.lamb.permissionsystem.repository.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @program: decisionsupportsystem
 * @description: 用户token表
 * @author: Mr.WangGang
 * @create: 2018-08-24 14:40
 **/
@Data
@Table(name = "user_token")
public class UserTokenDO {
    /*用户 uuid*/
    @Id
    @Column(name="user_id")
    private String userId;

    /*token*/
    @Column(name="user_token")
    private String userToken;

    /*创建时间*/
    @Column(name = "create_time")
    private Timestamp createTime;
}
