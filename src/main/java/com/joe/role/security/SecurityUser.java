package com.joe.role.security;

import com.joe.role.entity.Role;
import com.joe.role.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SecurityUser extends User implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private Role role;
    private Date lastPasswordResetDate;

    public SecurityUser(Integer id, String username, String password,Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public SecurityUser(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public SecurityUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    //返回分配给用户的权限列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    //账户是否未过期,过期无法验证
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //指定用户是否解锁,锁定的用户无法进行身份验证
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //指示是否已过期的用户的凭据(密码),过期的凭据防止认证
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //是否可用 ,禁用的用户不能身份验证
    @Override
    public boolean isEnabled() {
        return true;
    }
}