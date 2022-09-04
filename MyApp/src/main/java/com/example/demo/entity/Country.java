package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Entity
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer countryId;
	
	@NotNull(message="country name should not be null")
	@NotEmpty(message="country name should not be empty")
	@Size(min=3, max= 20,message="country length should be 3 to 20")
	private String countryName;
	
	@NotNull(message="country code should not be null")
	@NotEmpty(message="country code should not be empty")
	@Size(min=3, max=3,message="country code should be 3 char")
	private String countryCode;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="country_fk",referencedColumnName="countryId")
	private List<Company> companies;


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountrycode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	
}
