package com.tedu.sois.stu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tedu.sois.common.pojo.BaseEntity;

import java.util.Objects;

/**
 * 班级表
 */
@TableName("class_table")
public class ClassTable extends BaseEntity {

    /**自增id*/
    @TableId(type = IdType.AUTO)
    private Integer classId;

    /**班级*/
    private String ClassNum;

    /**方向*/
    private String classDirection;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassNum() {
        return ClassNum;
    }

    public void setClassNum(String classNum) {
        ClassNum = classNum;
    }

    public String getClassDirection() {
        return classDirection;
    }

    public void setClassDirection(String classDirection) {
        this.classDirection = classDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTable that = (ClassTable) o;
        return Objects.equals(classId, that.classId) &&
                Objects.equals(ClassNum, that.ClassNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, ClassNum);
    }

    @Override
    public String toString() {
        return "ClassTable{" +
                "classId=" + classId +
                ", ClassNum='" + ClassNum + '\'' +
                ", classDirection='" + classDirection + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
