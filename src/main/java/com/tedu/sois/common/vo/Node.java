package com.tedu.sois.common.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 节点值对象,一般用于封装树结构中的具体对象信息
 * @author Administrator
 */
public class Node implements Serializable{

	/**节点id*/
	private Integer id;

	/**节点名称*/
	private String name;


	private Boolean open = false;
	private Boolean checked = false;

	/**上级节点id*/
	private Integer parentId;


	/**下级节点集合*/
	private List<Node> children = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	@JsonIgnore
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Node{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parentId=" + parentId +
				", children=" + children +
				'}';
	}
}
