package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;



@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public Country saveCountry(Country c) {
		return countryRepo.save(c); }
	
	@Override
	public List<Country> getAllCntrs() {
		return countryRepo.findAll(); }
}
