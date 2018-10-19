package com.lamb.permissionsystem.repository.dao.repository;


import com.lamb.permissionsystem.entity.domain.ServiceDO;
import org.lamb.lambframework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @description: 基础查询
 * @author: Mr.WangGang
 * @create: 2018-10-17 上午 10:24
 **/
public interface FoundationQueryRepository extends LambDORepository<ServiceDO> {

    @Query(nativeQuery = true,value =
            "SELECT DISTINCT " +
            "services.* "+
            "FROM user users " +
            "inner join user_role ur on users.user_id = ur.user_id " +
            "inner join role_service rs on ur.role_id = rs.role_id " +
            "inner join service services on services.service_id = rs.service_id " +
            "where users.user_id = ?1"
    )
    public Optional<List<ServiceDO>> findServiceByUserId(Integer userId);

    @Query(nativeQuery = true,value =
            "select " +
            "services.* " +
            "FROM service services " +
            "where services.service_code = ?1"
    )
    public Optional<ServiceDO> findByServiceCode(String serviceCode);
}
