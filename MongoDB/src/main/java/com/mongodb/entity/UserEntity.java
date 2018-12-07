package com.mongodb.entity;

import java.io.Serializable;

/**
 * 功能:
 *
 * @date: 2018-10-16 10:08
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class UserEntity implements Serializable {
    
    private static final long serialVersionUID = -2295305349468900914L;
    private Long id;
    private String userName;
    private String passWord;
    
    public Long getId() {
        return id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(final String passWord) {
        this.passWord = passWord;
    }
}
