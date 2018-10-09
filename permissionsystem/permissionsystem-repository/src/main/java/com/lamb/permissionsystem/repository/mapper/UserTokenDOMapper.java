package com.lamb.permissionsystem.repository.mapper;

import com.lamb.permissionsystem.repository.adapter.LambMapper;
import com.lamb.permissionsystem.repository.domain.UserTokenDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: decisionsupportsystem
 * @description: 用户token表DAO
 * @author: Mr.WangGang
 * @create: 2018-08-24 14:42
 **/
@Mapper
public interface UserTokenDOMapper extends LambMapper<UserTokenDO> {

}
