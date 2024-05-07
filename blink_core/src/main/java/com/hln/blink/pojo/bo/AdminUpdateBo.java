package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class AdminUpdateBo implements Serializable {

    private String token;
    private Long userId;
    private Integer role;

    public AdminUpdateBo(){}

    public AdminUpdateBo(String token, Long userId, Integer role) {
        this.token = token;
        this.userId = userId;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AdminUpdateBo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                ", role=" + role +
                '}';
    }
}
