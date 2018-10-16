package com.lamb.permissionsystem.repository.dao.repository;


import com.lamb.permissionsystem.repository.entity.domain.ServiceDO;
import org.lamb.lambframework.core.supper.LambDORepository;

import java.util.Optional;

/**
 * @description: 服务表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:51
 **/
public interface ServiceDORepository extends LambDORepository<ServiceDO> {

    public Optional<ServiceDO> findByServiceCode(String serviceCode);

}
