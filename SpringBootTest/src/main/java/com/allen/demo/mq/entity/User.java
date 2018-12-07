package com.allen.demo.mq.entity;

/**
 * 功能:
 *
 * @date: 2018-10-15 10:19
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class User {
    private String name;
    private String pwd;
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", pwd='" + pwd + '\'' + '}';
    }
}
