package com.hln.blink.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class UserRegBo implements Serializable {

    private String username;//用户名
    private String password;//密码
    private Integer sex;//性别
    private Date birthData;//出生日期

    public UserRegBo(){}

    public UserRegBo(String username, String password, Integer sex, Date birthData) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthData = birthData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthData() {
        return birthData;
    }

    public void setBirthData(Date birthData) {
        this.birthData = birthData;
    }

    @Override
    public String toString() {
        return "UserRegBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthData=" + birthData +
                '}';
    }
}
