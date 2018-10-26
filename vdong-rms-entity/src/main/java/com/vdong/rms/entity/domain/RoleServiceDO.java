package com.vdong.rms.entity.domain;


import com.vdong.rms.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 角色服务关联表
 * @author: Mr.WangGang
 * @create: 2018-10-09 下午 1:10
 **/
@Data
@Entity
@Table(name = "role_service")
public class RoleServiceDO  extends SupperDO {
    @Id
    @Column(name="role_service_id")
    private Integer roleServiceId;

    @Column(name="role_id")
    private Integer roleId;

    @Column(name="service_id")
    private Integer serviceId;
}
