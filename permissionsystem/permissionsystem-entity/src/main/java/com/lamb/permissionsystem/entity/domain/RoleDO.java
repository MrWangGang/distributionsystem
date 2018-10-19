package com.lamb.permissionsystem.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 角色表
 * @author: Mr.WangGang
 * @create: 2018-10-09 上午 11:52
 **/

@Data
@Entity
@Table(name = "role")
public class RoleDO {
    @Id
    @Column(name="role_id")
    private Integer roleId;

    @Column(name="role_name")
    private String roleName;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
