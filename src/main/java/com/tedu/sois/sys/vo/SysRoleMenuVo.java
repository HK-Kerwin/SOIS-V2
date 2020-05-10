package com.tedu.sois.sys.vo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *     通过此对象封装基于角色id查询到的角色以
 *     及对应的菜单id
 */
public class SysRoleMenuVo implements Serializable{
	private static final long serialVersionUID = 3609240922718345518L;
	/**角色id*/
	private Integer roleId;
	/**角色名称*/
	private String roleName;
    /**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Integer> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysRoleMenuVo that = (SysRoleMenuVo) o;
		return Objects.equals(roleId, that.roleId) &&
				Objects.equals(roleName, that.roleName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, roleName);
	}

	@Override
	public String toString() {
		return "SysRoleMenuVo{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", note='" + note + '\'' +
				", menuIds=" + menuIds +
				'}';
	}
}
