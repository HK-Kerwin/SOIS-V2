package com.tedu.sois.sys.service;
import com.tedu.sois.common.vo.JsonResult;
import com.tedu.sois.common.vo.PageObject;
import com.tedu.sois.sys.entity.SysLog;
/**
 * 日志业务处理接口对象
 */
public interface SysLogService {
	
	/**
	 * 保存用户行为日志
	 * @param entity
	 */
	void saveLogInfo(SysLog entity);
	
	/**
	  *  执行删除业务
	 * @param ids 多个日志id
	 * @return 删除的行数
	 */
	int deleteObjects(Integer...ids);
	
     /**
            * 分页查询当前页记录
      * @param userName 查询条件
	  * @param page 页码
	  * @param limit 数量
      * @return 封装了分页信息和当前页记录的值对象
      */
	 JsonResult findPageLogInfoListByUserName(String userName, Integer page, Integer limit);
}
