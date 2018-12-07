package com.allen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * 功能:
 *
 * @date: 2018-10-16 15:58
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Entity
public class UserInfo implements Serializable {
    
    private static final long serialVersionUID = -2384069493179240729L;
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "user_name", unique = true)
    private String userName;//帐号
    @Column(unique = true)
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<SysRole> roleList;// 一个用户具有多个角色
    
    public Integer getUid() {
        return uid;
    }
    
    public void setUid(final Integer uid) {
        this.uid = uid;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(final String salt) {
        this.salt = salt;
    }
    
    public byte getState() {
        return state;
    }
    
    public void setState(final byte state) {
        this.state = state;
    }
    
    public Set<SysRole> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(final Set<SysRole> roleList) {
        this.roleList = roleList;
    }
    
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
    
    @Override
    public String toString() {
        return "UserInfo{" + "uid=" + uid + ", userName='" + userName + '\'' + ", name='" + name + '\'' + ", password='" + password + '\'' + ", salt='" + salt + '\'' + ", state="
               + state + ", roleList=" + roleList + '}';
    }
}
