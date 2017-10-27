package org.zt.ccty.springboot_mybatis_demo.config;

import org.apache.log4j.Logger;
import org.zt.ccty.springboot_mybatis_demo.enums.DataSourceEnums;

/**
 * 一个决策器-----> 利用ThreadLocal来获取线程池中的   读数据库  还是   写数据库  
 * @author Administrator
 *
 */
public class DataSourceContextHolder {

	
	private static Logger log = Logger.getLogger(DataSourceContextHolder.class);
	
	private static final ThreadLocal<String> local = new ThreadLocal<String>();  
	  
    public static ThreadLocal<String> getLocal() {  
        return local;  
    }  
  
    /** 
     * 读可能是多个库 
     */  
    public static void read() {  
  
        local.set(DataSourceEnums.read.getType());  
    }  
  
    /** 
     * 写只有一个库 
     */  
    public static void write() {  
        log.debug("writewritewrite");  
        local.set(DataSourceEnums.write.getType());  
    }  
  
    public static String getJdbcType() {  
        return local.get();  
    }  

}
