package com.allen.springboot.entity;

/**
 * 功能:
 *
 * @date: 2018-10-10 09:48
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class Grade {
    private Integer id;
    private String name;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
}
