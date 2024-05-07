package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class DeleteUserByIdBo implements Serializable {

    private String token;
    private Long id;

    public DeleteUserByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public DeleteUserByIdBo(){}

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

    @Override
    public String toString() {
        return "DeleteUserByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
