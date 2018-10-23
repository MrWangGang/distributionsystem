package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 系统表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:19
 **/
@Data
@Entity
@Table(name = "system")
public class SystemDO  extends SupperDO {

    @Id
    @Column(name="system_id")
    private Integer systemId;

    @Column(name="system_name")
    private String systemName;

    @Column(name="system_secret")
    private String systemSecret;
}
