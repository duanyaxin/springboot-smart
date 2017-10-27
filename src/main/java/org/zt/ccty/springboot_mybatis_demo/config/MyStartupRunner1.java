package org.zt.ccty.springboot_mybatis_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.zt.ccty.springboot_mybatis_demo.service.CountryService;
/*import org.zt.ccty.springboot_mybatis_demo.service.MyRedisService;*/

//@Component
//@Order(value=1)
public class MyStartupRunner1 implements CommandLineRunner {

	/*@Autowired
	private MyRedisService myRedisService;*/
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------初始化国家数据------------");
		/*myRedisService.redisInitData("china");*/
		System.out.println("--------初始化数据完成------------");
	}

}
