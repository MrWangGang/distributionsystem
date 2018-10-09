package com.lamb.permissionsystem.repository.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 角色表
 * @author: Mr.WangGang
 * @create: 2018-10-09 上午 11:52
 **/

@Data
@Table(name = "role")
public class RoleDO {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name="role_id")
    private String roleId;

    @Column(name="role_name")
    private String roleName;

    @Column(name="create_time")
    private String createTime;

    @Column(name="update_time")
    private String updateTime;
}
