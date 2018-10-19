package com.lamb.permissionsystem.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 规则表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:17
 **/
@Data
@Entity
@Table(name = "rule")
public class RuleDO {

    @Id
    @Column(name="rule_id")
    private Integer ruleId;

    @Column(name="rule_name")
    private String ruleName;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;
}
