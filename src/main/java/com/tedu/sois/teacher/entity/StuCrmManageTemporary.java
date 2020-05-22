package com.tedu.sois.teacher.entity;


import java.io.Serializable;
import java.util.Objects;

/**
 * 临时表实体对象
 */
public class StuCrmManageTemporary implements Serializable {

    /**编号*/
    private String column0;
    /**姓名*/
    private String column1;
    /**系列班級*/
    private String column2;
    /**班級*/
    private String column3;
    /**学员状态*/
    private String column4;
    /**合同发送类型*/
    private String column5;
    /**学费总值*/
    private String column6;
    /**尚欠学费*/
    private String column7;
    /**累计收款*/
    private String column8;
    /**累计缴费*/
    private String column9;
    /**进班日期*/
    private String column10;
    /**班级类型*/
    private String column11;
    /**学校*/
    private String column12;
    /**院系*/
    private String column13;
    /**学历*/
    private String column14;
    /**专业*/
    private String column15;
    /**就业状态*/
    private String column16;
    /**月报日期*/
    private String column17;
    /**教学中心*/
    private String column18;
    /**销售中心*/
    private String column19;
    /**咨询顾问*/
    private String column20;
    /**创建人*/
    private String column21;
    /**创建时间*/
    private String column22;
    /**公司*/
    private String column23;

    public String getColumn0() {
        return column0;
    }

    public void setColumn0(String column0) {
        this.column0 = column0;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn7() {
        return column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    public String getColumn8() {
        return column8;
    }

    public void setColumn8(String column8) {
        this.column8 = column8;
    }

    public String getColumn9() {
        return column9;
    }

    public void setColumn9(String column9) {
        this.column9 = column9;
    }

    public String getColumn10() {
        return column10;
    }

    public void setColumn10(String column10) {
        this.column10 = column10;
    }

    public String getColumn11() {
        return column11;
    }

    public void setColumn11(String column11) {
        this.column11 = column11;
    }

    public String getColumn12() {
        return column12;
    }

    public void setColumn12(String column12) {
        this.column12 = column12;
    }

    public String getColumn13() {
        return column13;
    }

    public void setColumn13(String column13) {
        this.column13 = column13;
    }

    public String getColumn14() {
        return column14;
    }

    public void setColumn14(String column14) {
        this.column14 = column14;
    }

    public String getColumn15() {
        return column15;
    }

    public void setColumn15(String column15) {
        this.column15 = column15;
    }

    public String getColumn16() {
        return column16;
    }

    public void setColumn16(String column16) {
        this.column16 = column16;
    }

    public String getColumn17() {
        return column17;
    }

    public void setColumn17(String column17) {
        this.column17 = column17;
    }

    public String getColumn18() {
        return column18;
    }

    public void setColumn18(String column18) {
        this.column18 = column18;
    }

    public String getColumn19() {
        return column19;
    }

    public void setColumn19(String column19) {
        this.column19 = column19;
    }

    public String getColumn20() {
        return column20;
    }

    public void setColumn20(String column20) {
        this.column20 = column20;
    }

    public String getColumn21() {
        return column21;
    }

    public void setColumn21(String column21) {
        this.column21 = column21;
    }

    public String getColumn22() {
        return column22;
    }

    public void setColumn22(String column22) {
        this.column22 = column22;
    }

    public String getColumn23() {
        return column23;
    }

    public void setColumn23(String column23) {
        this.column23 = column23;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuCrmManageTemporary that = (StuCrmManageTemporary) o;
        return Objects.equals(column0, that.column0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column0);
    }

    @Override
    public String toString() {
        return "StuCrmManageTemporary{" +
                "column0='" + column0 + '\'' +
                ", column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                ", column3='" + column3 + '\'' +
                ", column4='" + column4 + '\'' +
                ", column5='" + column5 + '\'' +
                ", column6='" + column6 + '\'' +
                ", column7='" + column7 + '\'' +
                ", column8='" + column8 + '\'' +
                ", column9='" + column9 + '\'' +
                ", column10='" + column10 + '\'' +
                ", column11='" + column11 + '\'' +
                ", column12='" + column12 + '\'' +
                ", column13='" + column13 + '\'' +
                ", column14='" + column14 + '\'' +
                ", column15='" + column15 + '\'' +
                ", column16='" + column16 + '\'' +
                ", column17='" + column17 + '\'' +
                ", column18='" + column18 + '\'' +
                ", column19='" + column19 + '\'' +
                ", column20='" + column20 + '\'' +
                ", column21='" + column21 + '\'' +
                ", column22='" + column22 + '\'' +
                ", column23='" + column23 + '\'' +
                '}';
    }
}
