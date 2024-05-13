package com.hln.blink.pojo.vo;

import java.io.Serializable;

public class ProfilesVo implements Serializable {

    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 姓名
     */
    private String name;
    private Integer sex;
    /**
     * 图片路径
     */
    private String img;
    /**
     * 身高
     */
    private Integer height;
    /**
     * 学历
     */
    private String educationLevel;
    /**
     * 职业
     */
    private String occupation;
    /**
     * 爱好
     */
    private String interestsHobbies;
    /**
     * 自我介绍
     */
    private String selfDescription;
    /**
     * 逻辑删除 0:存在 1:删除
     */
    private Integer delFlag;

    public ProfilesVo(){}

    public ProfilesVo(Long id, Long userId, String name, Integer sex, String img, Integer height, String educationLevel, String occupation, String interestsHobbies, String selfDescription, Integer delFlag) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.img = img;
        this.height = height;
        this.educationLevel = educationLevel;
        this.occupation = occupation;
        this.interestsHobbies = interestsHobbies;
        this.selfDescription = selfDescription;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "ProfilesVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", height=" + height +
                ", educationLevel='" + educationLevel + '\'' +
                ", occupation='" + occupation + '\'' +
                ", interestsHobbies='" + interestsHobbies + '\'' +
                ", selfDescription='" + selfDescription + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
