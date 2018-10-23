package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 服务表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:18
 **/
@Data
@Entity
@Table(name = "service")
public class ServiceDO  extends SupperDO {
    @Id
    @Column(name="service_id")
    private Integer serviceId;

    @Column(name="service_code")
    private String serviceCode;

    @Column(name="service_name")
    private String serviceName;

    @Column(name="service_strategy")
    private Byte serviceStrategy;
}
