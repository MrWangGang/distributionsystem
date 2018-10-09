package com.lamb.permissionsystem.repository.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;


/**
 * @description: 用户表
 * @author: Mr.WangGang
 * @create: 2018-08-24 14:29
 **/
@Data
@Table(name = "user")
public class UserDO implements UserDetails {
    /*用户 uuid*/
    @Id
    @Column(name="user_id")
    private String userId;

    /*用户名*/
    @Column(name = "user_name")
    private String userName;

    /*用户密码*/
    @Column(name = "user_password")
    private String userPassword;

    /*用户手机号*/
    @Column(name = "user_mobile")
    private String userMobile;

    /*用户邮箱*/
    @Column(name = "user_email")
    private String userEmail;

    /*创建时间*/
    @Column(name = "create_time")
    private Timestamp createTime;

    /*开始时间*/
    @Column(name = "update_time")
    private Timestamp updateTime;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return null;
    }

    public boolean isAccountNonExpired() {
        return false;
    }

    public boolean isAccountNonLocked() {
        return false;
    }

    public boolean isCredentialsNonExpired() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }
}
