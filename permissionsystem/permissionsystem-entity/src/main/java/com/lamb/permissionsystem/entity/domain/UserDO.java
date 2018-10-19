package com.lamb.permissionsystem.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 用户表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:20
 **/
@Data
@Entity
@Table(name = "user")
public class UserDO {

    @Id
    @Column(name="user_id")
    private Integer userId;

    @Column(name="system_id")
    private Integer systemId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_tag")
    private String userTag;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
