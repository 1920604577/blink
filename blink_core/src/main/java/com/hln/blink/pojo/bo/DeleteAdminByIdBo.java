package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class DeleteAdminByIdBo implements Serializable {

    private String token;
    private Long userId;

    public DeleteAdminByIdBo(){}

    public DeleteAdminByIdBo(String token, Long userId) {
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
        return "DeleteAdminByIdBo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
