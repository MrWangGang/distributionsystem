package com.lamb.permissionsystem.repository.dao.repository;

import com.lamb.permissionsystem.entity.domain.RuleRoleDO;
import org.lamb.lambframework.core.supper.LambDORepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @description: 规则与角色中间表DAO
 * @author: Mr.WangGang
 * @create: 2018-10-15 上午 10:49
 **/
public interface RuleRoleDORepository extends LambDORepository<RuleRoleDO> {
    @Query(nativeQuery = true,value =
            "select " +
                    "rr.* " +
                    "FROM rule_role rr " +
                    "where rr.rule_id = ?1"
    )
    public Optional<List<RuleRoleDO>> findByRuleId(Integer ruleId);

    @Query(nativeQuery = true,value =
            "select " +
                    "rr.* " +
                    "FROM rule_role rr " +
                    "where rr.role_id = ?1"
    )
    public Optional<List<RuleRoleDO>> findByRoleId(Integer roleId);
}
