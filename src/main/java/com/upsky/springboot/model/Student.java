package com.upsky.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private Date times;

    private Byte deleted;

    public Student(Long id, String name, Integer age, Date times, Byte deleted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.times = times;
        this.deleted = deleted;
    }

    public Student() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}