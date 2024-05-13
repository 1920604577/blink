package com.hln.blink.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class DatingEventsAddBo implements Serializable {

    private String token;
    private Date eventDate;
    private String message;
    private String location;
    private Long participant1Id;
    private Long participant2Id;

    public DatingEventsAddBo(){}

    public DatingEventsAddBo(String token, Date eventDate, String message, String location, Long participant1Id, Long participant2Id) {
        this.token = token;
        this.eventDate = eventDate;
        this.message = message;
        this.location = location;
        this.participant1Id = participant1Id;
        this.participant2Id = participant2Id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DatingEventsAddBo(String token, Date eventDate, String location, Long participant1Id, Long participant2Id) {
        this.token = token;
        this.eventDate = eventDate;
        this.location = location;
        this.participant1Id = participant1Id;
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
        return "DatingEventsAddBo{" +
                "token='" + token + '\'' +
                ", eventDate=" + eventDate +
                ", message='" + message + '\'' +
                ", location='" + location + '\'' +
                ", participant1Id=" + participant1Id +
                ", participant2Id=" + participant2Id +
                '}';
    }
}