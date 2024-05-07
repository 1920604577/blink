package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class TokenBo implements Serializable {

    private String token;

    public TokenBo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenBo{" +
                "token='" + token + '\'' +
                '}';
    }
}
