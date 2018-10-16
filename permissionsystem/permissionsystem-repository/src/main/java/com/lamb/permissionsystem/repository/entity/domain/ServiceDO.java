package com.lamb.permissionsystem.repository.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 服务表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:18
 **/
@Data
@Entity
@Table(name = "service")
public class ServiceDO {
    @Id
    @Column(name="service_id")
    private Integer serviceId;

    @Column(name="service_code")
    private String serviceCode;

    @Column(name="service_strategy")
    private Byte serviceStrategy;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
