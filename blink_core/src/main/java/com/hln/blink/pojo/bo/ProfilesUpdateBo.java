package com.hln.blink.pojo.bo;

import java.io.Serializable;

public class ProfilesUpdateBo implements Serializable {

    private String token;
    private Long userId;
    private Integer height;//身高
    private String educationLevel;//学历
    private String occupation;//职业
    private String interestsHobbies;//爱好
    private String selfDescription;//自我介绍

    public ProfilesUpdateBo(){}

    public ProfilesUpdateBo(String token, Long userId, Integer height, String educationLevel, String occupation, String interestsHobbies, String selfDescription) {
        this.token = token;
        this.userId = userId;
        this.height = height;
        this.educationLevel = educationLevel;
        this.occupation = occupation;
        this.interestsHobbies = interestsHobbies;
        this.selfDescription = selfDescription;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getInterestsHobbies() {
        return interestsHobbies;
    }

    public void setInterestsHobbies(String interestsHobbies) {
        this.interestsHobbies = interestsHobbies;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    @Override
    public String toString() {
        return "ProfilesUpdateBo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                ", height=" + height +
                ", educationLevel='" + educationLevel + '\'' +
                ", occupation='" + occupation + '\'' +
                ", interestsHobbies='" + interestsHobbies + '\'' +
                ", selfDescription='" + selfDescription + '\'' +
                '}';
    }
}
