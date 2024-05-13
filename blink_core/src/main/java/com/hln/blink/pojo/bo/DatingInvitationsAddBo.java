package com.hln.blink.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class DatingInvitationsAddBo implements Serializable {

    private String token;
    private Long senderId;
    private Long receiverId;
    private String message;
    private Date invitationDate;
    private Date invitationStatus;

    public DatingInvitationsAddBo (){}

    public DatingInvitationsAddBo(String token, Long senderId, Long receiverId, String message, Date invitationDate, Date invitationStatus) {
        this.token = token;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.invitationDate = invitationDate;
        this.invitationStatus = invitationStatus;
    }

    public DatingInvitationsAddBo(String token, Long senderId, Long receiverId, Date invitationDate, Date invitationStatus) {
        this.token = token;
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

    public Date getInvitationStatus() {
        return invitationStatus;
    }

    public void setInvitationStatus(Date invitationStatus) {
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
        return "DatingInvitationsAddBo{" +
                "token='" + token + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", message='" + message + '\'' +
                ", invitationDate=" + invitationDate +
                ", invitationStatus=" + invitationStatus +
                '}';
    }
}
