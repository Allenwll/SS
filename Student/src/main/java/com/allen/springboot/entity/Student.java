package com.allen.springboot.entity;

/**
 * 功能: 学生类
 *
 * @date: 2018-10-08 16:10
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Integer grade;
    private String gradeName;
    private Integer subject;
    private String subjectName;
    
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
    
    public String getGradeName() {
        return gradeName;
    }
    
    public void setGradeName(final String gradeName) {
        this.gradeName = gradeName;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    
    public void setSubjectName(final String subjectName) {
        this.subjectName = subjectName;
    }
}

