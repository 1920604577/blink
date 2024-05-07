package com.hln.blink.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class AdminVo implements Serializable {
    private Long id;

    private String username;
    private Integer sex;
    private Date birthData;
    private Integer role;

    public AdminVo(){}

    public AdminVo(Long id, String username, Integer sex, Date birthData, Integer role) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthData = birthData;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthData=" + birthData +
                ", role=" + role +
                '}';
    }
}
