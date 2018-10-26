package com.vdong.rms.repository.dao;


import com.vdong.rms.entity.domain.UserRoleDO;
import org.lamb.framework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @description: 用户与角色中间DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:54
 **/
public interface UserRoleDORepository extends LambDORepository<UserRoleDO> {
    @Query(nativeQuery = true,value =
            "select " +
                    "ur.* " +
                    "FROM user_role ur " +
                    "where ur.user_id = ?1"
    )
    public Optional<List<UserRoleDO>> findByUserId(Integer userId);
}
