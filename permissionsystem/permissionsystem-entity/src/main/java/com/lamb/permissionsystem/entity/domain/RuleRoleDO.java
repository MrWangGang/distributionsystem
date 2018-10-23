package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 规则和角色中间表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:18
 **/
@Data
@Entity
@Table(name = "rule_role")
public class RuleRoleDO  extends SupperDO {

    @Id
    @Column(name="rule_role_id")
    private Integer ruleRoleId;

    @Column(name="rule_id")
    private Integer ruleId;

    @Column(name="role_id")
    private Integer roleId;
}
