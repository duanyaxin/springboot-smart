package org.zt.ccty.springboot_mybatis_demo.redis;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.zt.ccty.springboot_mybatis_demo.common.SpringUtils;
import org.zt.ccty.springboot_mybatis_demo.config.RedisConfiguration;

@Service
@ContextConfiguration(classes = {RedisConfiguration.class,RedisManager.class} )
public class InitServiceManager {
	
	private static Logger logger = LogManager
			.getLogger(InitServiceManager.class);
	
	
	

	/*@Autowired
	private RedisManager myRedisService;*/
	
//	private RedisManager myRedisService = null;
	
	public InitServiceManager() {
		init();
	}
	
	private void init() {
		// 初始化全局参数配置
//		myRedisService = (RedisManager)SpringUtils.getBean(RedisManager.class);
		RedisManager myRedisService = (RedisManager)SpringUtils.getBean("redisManager");
//		一段测试代码的开始
		myRedisService.put("didi", "dididada");
		boolean b1 = myRedisService.keyExists("didi");
		Object data = myRedisService.get("didi");
		myRedisService.delete("didi");
		boolean b2 = myRedisService.keyExists("didi");
//		一段测试代码的结束
		
		myRedisService.redisInitData("china");
	}

	public void setMemecachedData() {
		logger.error("reset memcached");
		init();
	}
}
