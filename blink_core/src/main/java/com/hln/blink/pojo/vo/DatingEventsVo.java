package com.hln.blink.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class DatingEventsVo implements Serializable {

    private Long id;
    /**
     * 相亲活动日期
     */
    private Date eventDate;
    private String name;
    private String message;
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

    public DatingEventsVo(){}

    public DatingEventsVo(Long id, Date eventDate, String name, String message, String location, Long participant1Id, Long participant2Id, Integer delFlag) {
        this.id = id;
        this.eventDate = eventDate;
        this.name = name;
        this.message = message;
        this.location = location;
        this.participant1Id = participant1Id;
        this.participant2Id = participant2Id;
        this.delFlag = delFlag;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public String toString() {
        return "DatingEventsVo{" +
                "id=" + id +
                ", eventDate=" + eventDate +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", location='" + location + '\'' +
                ", participant1Id=" + participant1Id +
                ", participant2Id=" + participant2Id +
                ", delFlag=" + delFlag +
                '}';
    }
}
