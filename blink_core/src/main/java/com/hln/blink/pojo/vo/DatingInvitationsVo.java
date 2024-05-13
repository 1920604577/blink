package com.hln.blink.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class DatingInvitationsVo implements Serializable {

    private Long id;
    private String name;
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

    public DatingInvitationsVo(){}

    public DatingInvitationsVo(Long id, String name, Long senderId, Long receiverId, String message, Date invitationDate, Integer invitationStatus, Integer delFlag) {
        this.id = id;
        this.name = name;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.invitationDate = invitationDate;
        this.invitationStatus = invitationStatus;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "DatingInvitationsVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", message='" + message + '\'' +
                ", invitationDate=" + invitationDate +
                ", invitationStatus=" + invitationStatus +
                ", delFlag=" + delFlag +
                '}';
    }
}
