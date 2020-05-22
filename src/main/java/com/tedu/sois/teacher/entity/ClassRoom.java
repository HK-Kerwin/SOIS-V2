package com.tedu.sois.teacher.entity;

import com.tedu.sois.common.pojo.BaseEntity;

/**
 * 教室表
 * @author LYS
 */
public class ClassRoom extends BaseEntity {

    /**教室ID*/
    private Integer classRoomId;

    /**教室号*/
    private Integer classRoomNum;

    /**班级名字*/
    private String className;

    /**班级方向*/
    private String classDirection;

    /**项目经理*/
    private String projectManager;

    /**职业发展*/
    private String careerDevelopment;

    /**电脑*/
    private String computerNum;

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public Integer getClassRoomNum() {
        return classRoomNum;
    }

    public void setClassRoomNum(Integer classRoomNum) {
        this.classRoomNum = classRoomNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDirection() {
        return classDirection;
    }

    public void setClassDirection(String classDirection) {
        this.classDirection = classDirection;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getCareerDevelopment() {
        return careerDevelopment;
    }

    public void setCareerDevelopment(String careerDevelopment) {
        this.careerDevelopment = careerDevelopment;
    }

    public String getComputerNum() {
        return computerNum;
    }

    public void setComputerNum(String computerNum) {
        this.computerNum = computerNum;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classRoomId=" + classRoomId +
                ", classRoomNum=" + classRoomNum +
                ", className='" + className + '\'' +
                ", classDirection='" + classDirection + '\'' +
                ", projectManager='" + projectManager + '\'' +
                ", careerDevelopment='" + careerDevelopment + '\'' +
                ", computerNum='" + computerNum + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
