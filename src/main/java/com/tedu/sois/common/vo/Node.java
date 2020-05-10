package com.tedu.sois.common.vo;
import java.io.Serializable;

/**
 * 节点值对象,一般用于封装树结构中的具体对象信息
 * @author Administrator
 */
public class Node implements Serializable{
	private static final long serialVersionUID = 2048083156365694892L;
	/**
	 * 节点id
	 */
	private Integer id;
	/**
	 * 节点名称
	 */
	private String name;
	/**
	 * 上级节点信息
	 */
	private Integer parentId;

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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Node{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parentId=" + parentId +
				'}';
	}
}
