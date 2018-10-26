package com.vdong.rms.entity.domain;


import com.vdong.rms.entity.domain.supper.SupperDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 规则表
 * @author: Mr.WangGang
 * @create: 2018-10-12 下午 2:17
 **/
@Data
@Entity
@Table(name = "rule")
public class RuleDO  extends SupperDO {

    @Id
    @Column(name="rule_id")
    private Integer ruleId;

    @Column(name="system_id")
    private Integer systemId;

    @Column(name="rule_name")
    private String ruleName;

    @Column(name="user_tag")
    private String userTag;


}
