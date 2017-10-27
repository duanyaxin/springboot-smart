package org.zt.ccty.springboot_mybatis_demo.service;

import java.util.List;

import org.zt.ccty.springboot_mybatis_demo.model.Country;

public interface CountryService {

	public List<Country> getCountryInfo();
	
	public Country getCountryInfoById(String id);
	
	public void insertCountry(Country country);

	public void updateCountry(Country country);

	public void deleteCountryInfo(Integer id);
	
}
