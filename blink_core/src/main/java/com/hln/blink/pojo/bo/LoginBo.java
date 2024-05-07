package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class LoginBo implements Serializable {

    private String username;//用户名
    private String password;//密码

    public LoginBo(){}

    public LoginBo(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "LoginBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
