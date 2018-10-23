package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 系统与服务中间表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:19
 **/
@Data
@Entity
@Table(name = "system_service")
public class SystemServiceDO  extends SupperDO {
    @Id
    @Column(name="system_service_id")
    private Integer systemServiceId;

    @Column(name="system_id")
    private Integer systemId;

    @Column(name="service_id")
    private Integer serviceId;
}
