package com.allen.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * 功能:
 *
 * @date: 2018-10-16 16:04
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Integer id; // 编号
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
    
    //角色 权限关系
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns = {@JoinColumn(name="roleId")},
        inverseJoinColumns = {@JoinColumn(name="permissionId")})
    private Set<SysPermission> permissions;
    
    //用户  角色关系定义
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="SysUserRole",joinColumns = {@JoinColumn(name="roleId")},
        inverseJoinColumns = {@JoinColumn(name="uid")})
    private Set<UserInfo> userInfos; //一个角色对应多个用户
    
    public Integer getId() {
        return id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(final String role) {
        this.role = role;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public Boolean getAvailable() {
        return available;
    }
    
    public void setAvailable(final Boolean available) {
        this.available = available;
    }
    
    public Set<SysPermission> getPermissions() {
        return permissions;
    }
    
    public void setPermissions(final Set<SysPermission> permissions) {
        this.permissions = permissions;
    }
    
    public Set<UserInfo> getUserInfos() {
        return userInfos;
    }
    
    public void setUserInfos(final Set<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
