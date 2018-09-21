package com.lamb.distributionsystem.repository.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: decisionsupportsystem
 * @description: 数据字典表
 * @author: Mr.WangGang
 * @create: 2018-08-24 14:51
 **/
@Data
@Table(name = "dict")
public class DictDO {

    @Id
    @Column(name="k")
    private String key;

    @Column(name="v")
    private String value;

    @Column(name="create_time")
    private String createTime;

    @Column(name="update_time")
    private String updateTime;

}
