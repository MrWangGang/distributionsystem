package com.lamb.permissionsystem.repository.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 权限表
 * @author: Mr.WangGang
 * @create: 2018-10-09 上午 11:43
 **/
@Data
@Table(name = "permission")
public class PermissionDO {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name="permission_id")
    private String permissionId;

    @Column(name="permission_name")
    private String permissionName;

    @Column(name="create_time")
    private String createTime;

    @Column(name="update_time")
    private String updateTime;
}
