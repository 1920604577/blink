package com.hln.blink.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (DatingEvents)实体类
 *
 * @author makejava
 * @since 2024-05-07 18:48:49
 */
public class DatingEvents implements Serializable {
    private static final long serialVersionUID = 702333811669136346L;

    private Long id;
    /**
     * 相亲活动日期
     */
    private Date eventDate;
    /**
     * 相亲活动地点
     */
    private String location;
    /**
     * 参与者1 ID
     */
    private Long participant1Id;
    /**
     * 参与者2 ID
     */
    private Long participant2Id;
    /**
     * 逻辑删除 0:存在 1:删除
     */
    private Integer delFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getParticipant1Id() {
        return participant1Id;
    }

    public void setParticipant1Id(Long participant1Id) {
        this.participant1Id = participant1Id;
    }

    public Long getParticipant2Id() {
        return participant2Id;
    }

    public void setParticipant2Id(Long participant2Id) {
        this.participant2Id = participant2Id;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}

