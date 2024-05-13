package com.hln.blink.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class DatingInvitationsUpdateBo implements Serializable {

    private String token;
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

    public DatingInvitationsUpdateBo (){}

    public DatingInvitationsUpdateBo(String token, Long id, Long senderId, Long receiverId, String message, Date invitationDate, Integer invitationStatus) {
        this.token = token;
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.invitationDate = invitationDate;
        this.invitationStatus = invitationStatus;
    }

    public DatingInvitationsUpdateBo(String token, Long id, Long senderId, Long receiverId, Date invitationDate, Integer invitationStatus) {
        this.token = token;
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.invitationDate = invitationDate;
        this.invitationStatus = invitationStatus;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DatingInvitationsUpdateBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", message='" + message + '\'' +
                ", invitationDate=" + invitationDate +
                ", invitationStatus=" + invitationStatus +
                '}';
    }
}
