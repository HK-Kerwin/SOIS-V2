package com.tedu.sois.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tedu.sois.common.vo.CheckBox;
import com.tedu.sois.sys.entity.SysRole;
import com.tedu.sois.sys.vo.SysRoleMenuVo;


public interface SysRoleDao {
	  /**
	      * 查询所有角色
	   * @return
	   */
	  @Select("select role_id,roleName from sys_role")
	  List<CheckBox> findObjects();
	  /**
	      * 基于角色id查询角色以及角色对象的菜单id
	   * @param roleId
	   * @return
	   */
	  SysRoleMenuVo selectRoleAndMenuInfoById(Integer roleId);
	  /**
	      * 更新角色自身信息
	   * @param entity
	   * @return
	   */
	  int updateObject(SysRole entity);
	  /**
	      * 保存角色自身信息
	   * @param entity
	   * @return
	   */
 	  int insertObject(SysRole entity);
	   /**
	        * 基于角色删除角色自身信息
	    * @param roleId
	    * @return
	    */
	   @Delete("delete from sys_role where role_id=#{roleId}")
	   int deleteObject(Integer roleId);
       /**
                * 基于条件统计角色记录总数
        * @param roleName 角色名
        * @return 统计数量
        */
	   int getRoleInfoRowCount(@Param("roleName")String roleName);
	   /**
	        * 查询当前页角色记录
	    * @param roleName 角色名
	    * @param startIndex 当前页起始位置
	    * @param pageSize 当前页面大小
	    * @return 当前页角色记录
	    */
	   List<SysRole> selectRoleInfoPage(
			   @Param("roleName")String roleName,
			   @Param("startIndex")Integer startIndex,
			   @Param("pageSize")Integer pageSize);
}





