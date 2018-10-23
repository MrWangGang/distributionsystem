package com.lamb.permissionsystem.entity.domain;

import com.lamb.permissionsystem.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 规则自动配置表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:18
 **/
@Data
@Entity
@Table(name = "rule_auto_config")
public class RuleAutoConfigDO  extends SupperDO {
    @Id
    @Column(name="rule_auto_config_id")
    private Integer ruleAutoConfigId;

    @Column(name="rule_id")
    private Integer ruleId;

    @Column(name="system_id")
    private Integer systemId;

    @Column(name="user_tag")
    private String userTag;
}
