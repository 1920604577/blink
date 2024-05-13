package com.hln.blink.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class DatingEventsUpdateBo implements Serializable {

    private String token;
    private Long id;
    private Date eventDate;
    private String message;
    private String location;
    private Long participant1Id;
    private Long participant2Id;

    public DatingEventsUpdateBo(){}

    public DatingEventsUpdateBo(String token, Long id, Date eventDate, String message, String location, Long participant1Id, Long participant2Id) {
        this.token = token;
        this.id = id;
        this.eventDate = eventDate;
        this.message = message;
        this.location = location;
        this.participant1Id = participant1Id;
        this.participant2Id = participant2Id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DatingEventsUpdateBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", eventDate=" + eventDate +
                ", message='" + message + '\'' +
                ", location='" + location + '\'' +
                ", participant1Id=" + participant1Id +
                ", participant2Id=" + participant2Id +
                '}';
    }
}
