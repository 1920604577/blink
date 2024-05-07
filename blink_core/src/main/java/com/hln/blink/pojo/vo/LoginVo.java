package com.hln.blink.pojo.vo;

import com.hln.blink.pojo.User;

public class LoginVo {

    private User user;
    private Integer role;
    private String token;

    public LoginVo(){}

    public LoginVo(User user, Integer role, String token) {
        this.user = user;
        this.role = role;
        this.token = token;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "user=" + user +
                ", role=" + role +
                ", token='" + token + '\'' +
                '}';
    }
}
