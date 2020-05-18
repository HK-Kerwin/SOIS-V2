package com.tedu.sois.sys.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.sois.stu.entity.StuBaseInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tedu.sois.sys.entity.SysUser;
import com.tedu.sois.sys.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Select;


public interface SysUserDao extends BaseMapper<SysUser> {

    /**
     * 修改密码,会自动保存修改时间
     *
     * @param password     新加密后的密码
     * @param salt         新盐值
     * @param userId       用户id
     * @param modifiedUser 修改人
     * @return
     */
    int updatePassword(
            @Param("password") String password
            , @Param("salt") String salt
            , @Param("userId") Long userId
            , @Param("modifiedUser") String modifiedUser);

    SysUser findUserByLoginName(String username);

    /**
     * 根据用户id查询用户信息和部门信息
     *
     * @param userId 用户id
     * @return
     */
    SysUserDeptVo selectUserDeptVoById(Long userId);

    /**
     * 更新用户自身信息
     *
     * @param entity
     * @return
     */
    int updateSysUserInfo(SysUser entity);

    /**
     * 保存用户自身信息
     *
     * @param entity
     * @return
     */
    int insertSysUser(SysUser entity);

    /**
     * 根据ID删除数据
     * @param userId
     */
    @Delete("delete from sys_user where user_id=#{userId}")
    int deleteSysUserInfoById(Long userId);

    /**
     * 用户禁用启用数据状态的修改
     *
     * @param userId       用户id
     * @param status       用户状态
     * @param modifiedUser 修改用户
     * @return 修改行数
     */
    int updateStatusById(
            @Param("userId") Long userId,
            @Param("status") Integer status,
            @Param("modifiedUser") String modifiedUser);

    /**
     * 按条件统计记录总数
     *
     * @param userName
     * @return
     */
    int getRowCount(@Param("userName") String userName);

    /**
     * 按条件分页查询用户信息
     *
     * @param userName
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysUserDeptVo> findPageSysUserDeptVo(
            @Param("userName") String userName,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);


    @Select("select count(*) from sys_user where dept_id=#{deptId}")
    int getUserCountByDeptId(Integer deptId);


}








