package org.zt.ccty.springboot_mybatis_demo.quartz;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.zt.ccty.springboot_mybatis_demo.common.SpringUtils;
import org.zt.ccty.springboot_mybatis_demo.redis.InitServiceManager;
import org.zt.ccty.springboot_mybatis_demo.redis.RedisManager;

/**
 * 任务类
 * @author Administrator
 *
 */
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加 
public class CachedDataTask /*implements org.quartz.Job*/ {
	private static Logger logger = LogManager.getLogger(CachedDataTask.class);
	
	/**
	 * 
	 * @Title: clearMemcachedData
	 * @Description: 清空当天广告push数
	 * @param
	 * @return void
	 * @throws
	 */
	public void clearMemcachedData() {
		// 业务逻辑
		logger.info("开始清空Memcached缓存中当天数据--" + new Date());
		RedisManager.getInstance().clear();
		logger.info("清空当天push数完成......");

		logger.info("定时任务清空所有初始化，重新初始化......");
		/*InitServiceManager initServiceManager = (InitServiceManager) SpringUtils
				.getBean("initServiceManager");
		initServiceManager.setMemecachedData();*/
	}
	
	public void run() {
		System.out.println("定时器起作用了。。。。。。。。");
		clearMemcachedData();
	}
	
	
}
