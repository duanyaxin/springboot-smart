package org.zt.ccty.springboot_mybatis_demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zt.ccty.springboot_mybatis_demo.model.Country;

public interface CountryDao {
	public List<Country> getCountryInfo();

	public Country getCountryInfoById(@Param("id") String id);
	
	public void  insertCountry(Country country);

	public void updateCountry(Country country);

	public void deleteCountry(Integer id);
}
