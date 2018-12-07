package com.allen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 功能: 学生类
 *
 * @date: 2018-10-08 16:10
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Entity(name="Student")
@Table(name="t_student")
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private String sex;
    @Column(name=" gradeId")
    private Integer grade;
    @Column(name=" subjectId")
    private Integer subject;
    
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
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(final Integer age) {
        this.age = age;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(final String sex) {
        this.sex = sex;
    }
    
    public Integer getGrade() {
        return grade;
    }
    
    public void setGrade(final Integer grade) {
        this.grade = grade;
    }
    
    public Integer getSubject() {
        return subject;
    }
    
    public void setSubject(final Integer subject) {
        this.subject = subject;
    }
    
    public Student() {
    }
}

