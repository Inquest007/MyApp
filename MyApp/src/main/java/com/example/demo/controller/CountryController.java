package com.example.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Country;
import com.example.demo.exception.CountryServiceException;
import com.example.demo.service.CountryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/country-services")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@PostMapping
	public ResponseEntity<Country> saveCountry(@Valid @RequestBody Country country) throws CountryServiceException {
		return Optional.ofNullable(country)
				.map(countryService::saveCountry)
				.filter(Objects::nonNull)
				.map(r-> new ResponseEntity<>(r,HttpStatus.CREATED))
				.orElseThrow(()-> new CountryServiceException("country is not saved."));
	}
	
	@GetMapping
	public ResponseEntity<List<Country>> getAllCoun() {
		return Optional.ofNullable(countryService.getAllCntrs())
				.map(r-> new ResponseEntity<>(r,HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.OK));
	}
	
	

//	@PostMapping
//	public String saveCountry(@Valid @RequestBody Country country) {
//		System.out.println(country.getCountryName());
//		System.out.println(country.getCountryCode());
//		countryService.saveCountry(country);
//		return "created";
//	}
}
