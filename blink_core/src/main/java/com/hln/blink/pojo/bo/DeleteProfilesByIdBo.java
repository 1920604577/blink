package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class DeleteProfilesByIdBo implements Serializable {

    private String token;
    private Long userId;

    public DeleteProfilesByIdBo(){}

    public DeleteProfilesByIdBo(String token, Long userId) {
        this.token = token;
        this.userId = userId;
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

    @Override
    public String toString() {
        return "DeleteProfilesByIdBo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
