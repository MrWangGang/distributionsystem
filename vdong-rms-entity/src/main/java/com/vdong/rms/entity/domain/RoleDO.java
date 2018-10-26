package com.vdong.rms.entity.domain;


import com.vdong.rms.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 角色表
 * @author: Mr.WangGang
 * @create: 2018-10-09 上午 11:52
 **/

@Data
@Entity
@Table(name = "role")
public class RoleDO  extends SupperDO {
    @Id
    @Column(name="role_id")
    private Integer roleId;

    @Column(name="role_name")
    private String roleName;
}
