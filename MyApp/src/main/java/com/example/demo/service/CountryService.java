package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Country;

public interface CountryService {
  
	Country saveCountry(Country country);
	
	List<Country> getAllCntrs();
}
