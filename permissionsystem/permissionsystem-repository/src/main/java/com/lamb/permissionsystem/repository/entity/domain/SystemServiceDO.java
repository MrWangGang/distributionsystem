package com.lamb.permissionsystem.repository.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 系统与服务中间表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:19
 **/
@Data
@Entity
@Table(name = "system_service")
public class SystemServiceDO {
    @Id
    @Column(name="system_service_id")
    private Integer systemServiceId;

    @Column(name="system_id")
    private Integer systemId;

    @Column(name="service_id")
    private Integer serviceId;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
