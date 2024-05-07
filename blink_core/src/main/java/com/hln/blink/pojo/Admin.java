package com.hln.blink.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2024-04-30 09:10:42
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 729092160915247101L;

    private Long id;
/**
     *  用户id
     */
    private Long userId;
/**
     *  权限
     */
    private Integer role;
/**
     *  逻辑删除(0:存在 1:删除)
     */
    private Integer delFlag;

    public Admin(){}

    public Admin(Long id, Long userId, Integer role, Integer delFlag) {
        this.id = id;
        this.userId = userId;
        this.role = role;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userId=" + userId +
                ", role=" + role +
                ", delFlag=" + delFlag +
                '}';
    }
}

