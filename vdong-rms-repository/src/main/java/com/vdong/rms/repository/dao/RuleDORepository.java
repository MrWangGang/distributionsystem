package com.vdong.rms.repository.dao;


import com.vdong.rms.entity.domain.RuleDO;
import org.lamb.framework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


/**
 * @description: 规则表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:48
 **/
public interface RuleDORepository extends LambDORepository<RuleDO> {

    @Query(nativeQuery = true,value =
            "select " +
                    "rules.* " +
                    "FROM rule rules " +
                    "where rules.system_id = ?1"
    )
    public Optional<List<RuleDO>> findBySystemId(Integer systemId);
}
