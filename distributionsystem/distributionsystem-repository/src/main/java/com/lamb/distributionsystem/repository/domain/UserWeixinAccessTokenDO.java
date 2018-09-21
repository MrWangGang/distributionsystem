package com.lamb.distributionsystem.repository.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: decisionsupportsystem
 * @description: 用户微信ACCESS_TOKEN表
 * @author: Mr.WangGang
 * @create: 2018-08-26 16:50
 **/
@Data
@Table(name = "user_weixin_access_token")
public class UserWeixinAccessTokenDO {

    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="access_token")
    private String accessToken;

    @Column(name="refresh_token")
    private String refreshToken;

    @Column(name="open_id")
    private String openId;

    @Column(name="expires_in")
    private String expiresIn;

    @Column(name="create_time")
    private String createTime;
}
