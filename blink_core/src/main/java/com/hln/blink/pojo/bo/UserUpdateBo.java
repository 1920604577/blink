package com.hln.blink.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class UserUpdateBo implements Serializable {

    private String token;
    private Long id;
    /**
     *  用户名
     */
    private String username;
    /**
     *  性别
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private Date birthData;

    public UserUpdateBo(){}

    public UserUpdateBo(String token, Long id, String username, Integer sex, Date birthData) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthData = birthData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    @Override
    public String toString() {
        return "UserUpdateBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthData=" + birthData +
                '}';
    }
}
