package org.zt.ccty.springboot_mybatis_demo.dao;

import org.apache.ibatis.annotations.Param;
import org.zt.ccty.springboot_mybatis_demo.model.UserIntegral;

public interface IntegralDao {
	
	public UserIntegral getIntegralInfoById(@Param("id") String id);
	public UserIntegral getIntegralInfoByUid(@Param("uid") Integer uid);
	public void saveIntegral(UserIntegral integral);
	public void updateIntegral(UserIntegral integral);
}
