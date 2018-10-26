package com.vdong.rms.common.exception;


import com.vdong.rms.common.enums.ProcessExceptionEnum;
import org.lamb.framework.core.exception.basic.GlobalException;

/**
 * Created by WangGang on 2017/6/22 0022.
 * E-mail userbean@outlook.com
 * The final interpretation of this procedure is owned by the author
 */
public class ProcessException extends GlobalException {

    public ProcessException(ProcessExceptionEnum error) {
        super(error.getCode(),error.getMessage());
    }
}
