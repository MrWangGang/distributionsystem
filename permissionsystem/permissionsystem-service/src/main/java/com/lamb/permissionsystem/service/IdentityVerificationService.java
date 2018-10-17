package com.lamb.permissionsystem.service;

/**
 * @description: 身份验证
 * @author: Mr.WangGang
 * @create: 2018-10-17 下午 12:28
 **/
public interface IdentityVerificationService {
    public void validate(String serviceCode,String accessToken);
}
