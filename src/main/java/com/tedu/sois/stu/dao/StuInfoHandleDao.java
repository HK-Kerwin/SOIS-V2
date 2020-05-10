package com.tedu.sois.stu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.sois.stu.entity.StuBaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfoHandleDao extends BaseMapper<StuBaseInfo> {

    /**
     * 根据匹配班级统计数量
     * 若班级号为空则统计全部
     *
     * @param stuClass
     * @return
     */
    Integer getRowCount(@Param("stuName") String stuName,
                        @Param("stuClass") String stuClass,
                        @Param("classRoom") String classRoom);

    /**
     * 分页查询
     * 班级号或者教室号为空则全查询
     * 根据教室内学员的学历进行排序
     *
     * @param stuClass
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<StuBaseInfo> selectPageStuNameOrStuClassOrClassRoom(@Param("stuName") String stuName,
                                                    @Param("stuClass") String stuClass,
                                                    @Param("classRoom") String classRoom,
                                                    @Param("startIndex") int startIndex,
                                                    @Param("pageSize") int pageSize);


}
