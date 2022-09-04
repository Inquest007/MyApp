package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.enums.CompanyType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer companyId;
	
	@NotNull(message="company name should not be null")
	@NotEmpty(message="company name should not be empty")
	@Size(min=3, max= 20,message="company length should be 3 to 20")
	private String companyName;
	
	
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="company_fk",referencedColumnName="companyId")
	private List<Employee> employees;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
//
	public String getCompanyName() {
		return companyName;
	}
//
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
//
	public CompanyType getCompanyType() {
		return companyType;
	}
//
	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
//	
//	

}
