package com.tedu.sois.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.tedu.sois.common.vo.Node;
import com.tedu.sois.sys.entity.SysDept;

/**
 * 部门信息Dao接口
 */
public interface SysDeptDao {
    /**
     * 查询所有部门以及部门的上级菜单信息
     *
     * @return
     */
    @Select("select c.*,p.name parentName from sys_dept c left join sys_dept p on c.parentId=p.dept_dept_id")
    List<Map<String, Object>> findDeptInfoList();

    @Select("select dept_id,name,parentId from sys_dept")
    List<Node> findZTreeNodes();

	@Select("select count(*) from sys_dept where parentId=#{deptId}")
	int getChildCount(Integer dept_id);

	@Delete("delete from sys_dept where dept_id=#{deptId}")
	int deleteDeptInfoById(Integer dept_id);

    int insertDeptInfo(SysDept entity);

    List<SysDept> selectDeptInfoById(Integer dept_id);

    int updateDeptInfo(SysDept entity);
}







