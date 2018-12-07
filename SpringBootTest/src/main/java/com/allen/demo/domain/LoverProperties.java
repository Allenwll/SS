package com.allen.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 功能:
 *
 * @date: 2018-10-08 14:17
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Component
@ConfigurationProperties(prefix = "lover")
public class LoverProperties {
   
    private String name;
   
    private Integer age;
    
    private Double weight;
    
    private Double height;
    
    private String content;
    
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
    
    public Double getWeight() {
        return weight;
    }
    
    public void setWeight(final Double weight) {
        this.weight = weight;
    }
    
    public Double getHeight() {
        return height;
    }
    
    public void setHeight(final Double height) {
        this.height = height;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "LoverProperties{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + ", height=" + height + ", content='" + content + '\'' + '}';
    }
}
