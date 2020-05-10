package com.tedu.sois.sys.entity;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tedu.sois.common.pojo.BaseEntity;

import org.springframework.format.annotation.DateTimeFormat;

@TableName("sys_user")
public class SysUser extends BaseEntity {

	/**用户序号*/
	@TableId(type = IdType.AUTO)
	private Long userId;
	/**学生编号*/
	private Long stuId;

	/**部门编号*/
	private Long deptId;
	@TableField(exist = false)
	private Long parentId;
	@TableField(exist = false)
	private Long roleId;

	/**登录名称*/
	private String loginName;

	/**用户名称*/
	private String userName;

	/**用户类型（00系统用户）*/
	private String userType;

	/**用户邮箱*/
	private String email;

	/**手机号码*/
	private String phoneNumber;

	/**用户性别 0=男,1=女,2=未知*/
	private String sex;

	/**上传头像地址*/
	private String avatar;

	/**密码*/
	private String password;

	/**盐值*/
	private String salt;

	/**帐号状态 0=正常,1=停用*/
	private String status;

	/**最后登陆IP*/
	private String loginIp;

	/**最后登陆时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginDate;

	/**部门*/
	@TableField(exist = false)
	private SysDept dept;

	@TableField(exist = false)
	private List roles;
	@TableField(exist = false)
	private Long[] roleIds;
	@TableField(exist = false)
	private Long[] postIds;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public SysDept getDept() {
		return dept;
	}

	public void setDept(SysDept dept) {
		this.dept = dept;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public Long[] getPostIds() {
		return postIds;
	}

	public void setPostIds(Long[] postIds) {
		this.postIds = postIds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysUser sysUser = (SysUser) o;
		return Objects.equals(userId, sysUser.userId) &&
				Objects.equals(stuId, sysUser.stuId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, stuId);
	}

	@Override
	public String toString() {
		return "SysUser{" +
				"userId=" + userId +
				", stuId=" + stuId +
				", deptId=" + deptId +
				", parentId=" + parentId +
				", roleId=" + roleId +
				", loginName='" + loginName + '\'' +
				", userName='" + userName + '\'' +
				", userType='" + userType + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", sex='" + sex + '\'' +
				", avatar='" + avatar + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", status='" + status + '\'' +
				", loginIp='" + loginIp + '\'' +
				", loginDate=" + loginDate +
				", dept=" + dept +
				", roles=" + roles +
				", roleIds=" + Arrays.toString(roleIds) +
				", postIds=" + Arrays.toString(postIds) +
				", createdTime=" + createdTime +
				", modifiedTime=" + modifiedTime +
				", createdUser='" + createdUser + '\'' +
				", modifiedUser='" + modifiedUser + '\'' +
				", delFlag='" + delFlag + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
