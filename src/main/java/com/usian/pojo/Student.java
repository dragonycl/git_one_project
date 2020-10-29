package com.usian.pojo;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

public class Student {
    @Id
    private Integer id;
    private String name;
    private Integer sex;
    private String birthday;

    @Transient
    private String starttime;
    @Transient
    private String endtime;

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Student(Integer id, String name, Integer sex, String birthday, String starttime, String endtime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
