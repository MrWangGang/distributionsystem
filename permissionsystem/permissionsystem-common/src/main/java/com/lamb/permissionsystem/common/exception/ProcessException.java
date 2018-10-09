package com.lamb.permissionsystem.common.exception;

import com.lamb.permissionsystem.common.enums.ProcessExceptionEnum;
import org.lamb.lambframework.core.exception.basic.GlobalException;

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
