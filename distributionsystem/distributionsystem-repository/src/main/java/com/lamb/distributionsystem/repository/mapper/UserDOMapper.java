package com.lamb.distributionsystem.repository.mapper;

import com.lamb.distributionsystem.repository.adapter.LambMapper;
import com.lamb.distributionsystem.repository.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * @program: decisionsupportsystem
 * @description: 用户表DAO
 * @author: Mr.WangGang
 * @create: 2018-08-24 14:32
 **/
@Mapper
public interface UserDOMapper extends LambMapper<UserDO> {

}
