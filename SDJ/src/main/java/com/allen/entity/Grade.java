package com.allen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 功能:
 *
 * @date: 2018-10-10 09:48
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Entity(name="Grade")
@Table(name="t_grade")
public class Grade implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    
    public Long getId() {
        return id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public Grade() {
    }
}
