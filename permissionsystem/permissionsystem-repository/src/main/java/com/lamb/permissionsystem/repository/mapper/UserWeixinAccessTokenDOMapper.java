package com.lamb.permissionsystem.repository.mapper;

import com.lamb.permissionsystem.repository.adapter.LambMapper;
import com.lamb.permissionsystem.repository.domain.UserWeixinAccessTokenDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: decisionsupportsystem
 * @description: 用户微信ACCESS_TOKEN表DAO
 * @author: Mr.WangGang
 * @create: 2018-08-26 16:52
 **/
@Mapper
public interface UserWeixinAccessTokenDOMapper  extends LambMapper<UserWeixinAccessTokenDO> {

}
