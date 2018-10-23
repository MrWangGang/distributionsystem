package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 用户与角色中间表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:20
 **/
@Data
@Entity
@Table(name = "user_role")
public class UserRoleDO  extends SupperDO {

    @Id
    @Column(name="user_role_id")
    private Integer userRoleId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="role_id")
    private Integer roleId;
}
