package com.tedu.sois.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.tedu.sois.common.pojo.BaseEntity;
/**
 * 部门PO对象
 */
public class SysDept extends BaseEntity {
	private Integer deptId;
	private String deptName;
	private String leader;
	private Integer parentId;
	private Integer sort;
	private String note;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysDept sysDept = (SysDept) o;
		return Objects.equals(deptId, sysDept.deptId) &&
				Objects.equals(deptName, sysDept.deptName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptId, deptName);
	}

	@Override
	public String toString() {
		return "SysDept{" +
				"deptId=" + deptId +
				", deptName='" + deptName + '\'' +
				", leader='" + leader + '\'' +
				", parentId=" + parentId +
				", sort=" + sort +
				", note='" + note + '\'' +
				", createdTime=" + createdTime +
				", modifiedTime=" + modifiedTime +
				", createdUser='" + createdUser + '\'' +
				", modifiedUser='" + modifiedUser + '\'' +
				", delFlag='" + delFlag + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
