package com.lamb.permissionsystem.repository.dao.repository;

import com.lamb.permissionsystem.entity.domain.SystemServiceDO;
import org.lamb.lambframework.core.supper.LambDORepository;

import java.util.Optional;

/**
 * @description: 系统与服务中间表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:52
 **/
public interface SystemServiceDORepository extends LambDORepository<SystemServiceDO> {
    public Optional<SystemServiceDO> findByServiceId(Integer serviceId);

}
