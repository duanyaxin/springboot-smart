package org.zt.ccty.springboot_mybatis_demo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
/*import org.zt.ccty.springboot_mybatis_demo.service.MyRedisService;*/

//@Component
public class MyDisposableBean implements DisposableBean,ExitCodeGenerator{

	/*@Autowired
	private MyRedisService myRedisService;*/
	
	@Override
	public int getExitCode() {
		return 5;
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("<<<<<<<<<<<开始销毁redis..................>>>>>>>>>>>>>>>"); 
		/*myRedisService.deleteRedisByKey("china");*/
		System.out.println("<<<<<<<<<<<清除redis缓存完成..................>>>>>>>>>>>>>>>"); 
	}
	
	 /*@PreDestroy  
	    public void destory() {  
	  
	        System.out.println("我被销毁了、、、、、我是用的@PreDestory的方式、、、、、、");  
	        System.out.println("我被销毁了、、、、、我是用的@PreDestory的方式、、、、、、");  
	   } */ 
	
}
