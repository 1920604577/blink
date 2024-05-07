package com.hln.blink.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-04-30 09:10:46
 */
public class User implements Serializable {
    private static final long serialVersionUID = 486671719797191705L;

    private Long id;
/**
     *  用户名
     */
    private String username;
/**
     *  密码
     */
    private String password;
/**
     *  性别
     */
    private Integer sex;
/**
     * 出生日期
     */
    private Date birthData;
/**
     *  逻辑删除(0:存在 1:删除)
     */
    private Integer delFlag;

    public User(){}

    public User(Long id, String username, String password, Integer sex, Date birthData, Integer delFlag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthData = birthData;
        this.delFlag = delFlag;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthData=" + birthData +
                ", delFlag=" + delFlag +
                '}';
    }
}

