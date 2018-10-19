package com.lamb.permissionsystem.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 系统表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:19
 **/
@Data
@Entity
@Table(name = "system")
public class SystemDO {

    @Id
    @Column(name="system_id")
    private Integer systemId;

    @Column(name="system_name")
    private Integer systemName;

    @Column(name="system_secret")
    private Integer systemSecret;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
