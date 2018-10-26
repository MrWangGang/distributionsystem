package com.vdong.rms.service.function;


import com.vdong.rms.entity.domain.supper.SupperDO;

/**
 * @description: operation function
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 10:40
 **/
public interface OperationFunction<T extends SupperDO> {
    public void execute(T t);
}
