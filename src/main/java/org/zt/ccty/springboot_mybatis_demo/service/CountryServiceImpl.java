package org.zt.ccty.springboot_mybatis_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.ccty.springboot_mybatis_demo.dao.CountryDao;
import org.zt.ccty.springboot_mybatis_demo.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;
	
	@Override
	public List<Country> getCountryInfo() {
		return countryDao.getCountryInfo();
	}

	@Override
	public Country getCountryInfoById(String id) {
		return countryDao.getCountryInfoById(id);
	}

	@Override
	public void insertCountry(Country country) {
		countryDao.insertCountry(country);
	}

	@Override
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}

	@Override
	public void deleteCountryInfo(Integer id) {
		countryDao.deleteCountry(id);
	}

}
