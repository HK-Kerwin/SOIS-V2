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

    /**座位数*/
    private String seatNum;

    /**在读人数*/
    private String fullTimeStuNum;

    /**其他人数:毕业、VIP*/
    private String otherStuNum;

    /**项目经理*/
    private String projectManager;

    /**职业发展*/
    private String careerDevelopment;

    /**电脑数量*/
    private Integer computerNum;

    /**显示器数量*/
    private Integer displayNum;

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

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getFullTimeStuNum() {
        return fullTimeStuNum;
    }

    public void setFullTimeStuNum(String fullTimeStuNum) {
        this.fullTimeStuNum = fullTimeStuNum;
    }

    public String getOtherStuNum() {
        return otherStuNum;
    }

    public void setOtherStuNum(String otherStuNum) {
        this.otherStuNum = otherStuNum;
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

    public Integer getComputerNum() {
        return computerNum;
    }

    public void setComputerNum(Integer computerNum) {
        this.computerNum = computerNum;
    }

    public Integer getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(Integer displayNum) {
        this.displayNum = displayNum;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classRoomId=" + classRoomId +
                ", classRoomNum=" + classRoomNum +
                ", className='" + className + '\'' +
                ", classDirection='" + classDirection + '\'' +
                ", seatNum='" + seatNum + '\'' +
                ", fullTimeStuNum='" + fullTimeStuNum + '\'' +
                ", otherStuNum='" + otherStuNum + '\'' +
                ", projectManager='" + projectManager + '\'' +
                ", careerDevelopment='" + careerDevelopment + '\'' +
                ", computerNum=" + computerNum +
                ", displayNum=" + displayNum +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
