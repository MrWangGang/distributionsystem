package com.vdong.rms.entity.domain.supper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @description: DO超类
 * @author: Mr.WangGang
 * @create: 2018-10-23 上午 10:35
 **/
@Data
public abstract class SupperDO {

    public void timeSet() {
            Date now = new Date();
            Class clazz = this.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Id id = f.getAnnotation(Id.class);
                if(id!=null){
                    if(f!=null){
                        this.setUpdateTime(now);
                    }else {
                        this.setCreateTime(now);
                        this.setUpdateTime(now);
                    }
                    break;
                }
            }
    }


    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

}
