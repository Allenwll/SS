package com.allen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能:
 *
 * @date: 2018-10-18 10:26
 * @author: wanglulin@sinodata.net.cn
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String pwd;
    @Column(nullable = false)
    private int age;
    
    public long getId() {
        return id;
    }
    
    public void setId(final long id) {
        this.id = id;
    }
    
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(final int age) {
        this.age = age;
    }
}
