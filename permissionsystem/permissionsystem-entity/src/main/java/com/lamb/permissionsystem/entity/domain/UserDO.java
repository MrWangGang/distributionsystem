package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 用户表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:20
 **/
@Data
@Entity
@Table(name = "user")
public class UserDO  extends SupperDO {

    @Id
    @Column(name="user_id")
    private Integer userId;

    @Column(name="system_id")
    private Integer systemId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_tag")
    private String userTag;
}
