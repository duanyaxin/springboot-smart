package org.zt.ccty.springboot_mybatis_demo.config;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.zt.ccty.springboot_mybatis_demo.enums.DataSourceEnums;

/**
 * 数据库路由
 * @author Jack
 *
 */
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource{

	private final int dataSourceNumber;  
    private AtomicInteger count = new AtomicInteger(0);  
  
    public MyAbstractRoutingDataSource(int dataSourceNumber) {  
        this.dataSourceNumber = dataSourceNumber;  
    }  

	@Override
	protected Object determineCurrentLookupKey() {
		String typeKey = DataSourceContextHolder.getJdbcType();  
        if (typeKey.equals(DataSourceEnums.write.getType()))  
            return DataSourceEnums.write.getType();  
        // 读 简单负载均衡  
        int number = count.getAndAdd(1);  
        int lookupKey = number % dataSourceNumber;  
        return new Integer(lookupKey);  
	}

}
