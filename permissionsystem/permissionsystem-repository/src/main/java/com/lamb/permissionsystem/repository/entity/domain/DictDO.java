package com.lamb.permissionsystem.repository.entity.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 数据字典表
 * @author: Mr.WangGang
 * @create: 2018-08-24 14:51
 **/
@Data
@Entity
@Table(name = "dict")
public class DictDO {

    @Id
    @Column(name="dict_id")
    private Integer dictId;

    @Column(name="dict_key")
    private String dictKey;

    @Column(name="dict_value")
    private String dictValue;

    @Column(name="dict_note")
    private String dictNote;

    @Column(name="create_time")
    private String createTime;

    @Column(name="update_time")
    private String updateTime;

}
