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
	private Integer menuId;
	/**
	 * 节点名称
	 */
	private String menuName;
	/**
	 * 上级节点信息
	 */
	private Integer parentId;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
				"menuId=" + menuId +
				", menuName='" + menuName + '\'' +
				", parentId=" + parentId +
				'}';
	}
}
