package com.lamb.permissionsystem.repository.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 规则和角色中间表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:18
 **/
@Data
@Entity
@Table(name = "rule_role")
public class RuleRoleDO {

    @Id
    @Column(name="rule_role_id")
    private Integer ruleRoleId;

    @Column(name="rule_id")
    private Integer ruleId;

    @Column(name="role_id")
    private Integer roleId;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
