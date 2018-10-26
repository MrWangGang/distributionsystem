package com.vdong.rms.repository.dao;


import com.vdong.rms.entity.domain.RoleServiceDO;
import org.lamb.framework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @description: 角色与服务中间表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:46
 **/
public interface RoleServiceDORepository extends LambDORepository<RoleServiceDO> {

    @Query(nativeQuery = true,value =
            "select " +
                    "rs.* " +
                    "FROM role_service rs " +
                    "where rs.role_id = ?1"
    )
    public Optional<List<RoleServiceDO>> findByRoleId(Integer roleId);

    @Query(nativeQuery = true,value =
            "select " +
                    "rs.* " +
                    "FROM role_service rs " +
                    "where rs.service_id = ?1"
    )
    public Optional<List<RoleServiceDO>> findByServiceId(Integer serviceId);
}
