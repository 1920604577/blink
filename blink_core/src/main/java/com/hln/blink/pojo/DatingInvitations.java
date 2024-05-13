package com.hln.blink.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (DatingInvitations)实体类
 *
 * @author makejava
 * @since 2024-05-07 18:48:52
 */
public class DatingInvitations implements Serializable {
    private static final long serialVersionUID = -21060238461702244L;

    private Long id;
    /**
     * 发送者ID
     */
    private Long senderId;
    /**
     * 接收者ID
     */
    private Long receiverId;
    private String message;
    /**
     * 邀请日期
     */
    private Date invitationDate;
    /**
     * 0:待确认 1:已确认 2:已拒绝
     */
    private Integer invitationStatus;
    /**
     * 逻辑删除 0:存在 1:删除
     */
    private Integer delFlag;

    public DatingInvitations(Long id, Long senderId, Long receiverId, String message, Date invitationDate, Integer invitationStatus, Integer delFlag) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.invitationDate = invitationDate;
        this.invitationStatus = invitationStatus;
        this.delFlag = delFlag;
    }

    public DatingInvitations(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Date getInvitationDate() {
        return invitationDate;
    }

    public void setInvitationDate(Date invitationDate) {
        this.invitationDate = invitationDate;
    }

    public Integer getInvitationStatus() {
        return invitationStatus;
    }

    public void setInvitationStatus(Integer invitationStatus) {
        this.invitationStatus = invitationStatus;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "DatingInvitations{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", message='" + message + '\'' +
                ", invitationDate=" + invitationDate +
                ", invitationStatus=" + invitationStatus +
                ", delFlag=" + delFlag +
                '}';
    }
}

