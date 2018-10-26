package com.vdong.rms.repository.dao;


import com.vdong.rms.entity.domain.SystemServiceDO;
import org.lamb.framework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @description: 系统与服务中间表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:52
 **/
public interface SystemServiceDORepository extends LambDORepository<SystemServiceDO> {

    @Query(nativeQuery = true,value =
            "select " +
                    "ss.* " +
                    "FROM system_service ss " +
                    "where ss.service_id = ?1"
    )
    public Optional<SystemServiceDO> findByServiceId(Integer serviceId);

    @Query(nativeQuery = true,value =
            "select " +
                    "ss.* " +
                    "FROM system_service ss " +
                    "where ss.system_id = ?1"
    )
    public Optional<List<SystemServiceDO>> findBySystemId(Integer systemId);

}
