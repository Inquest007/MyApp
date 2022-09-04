package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empId;
	
	@NotNull(message="emp name should not be null")
	@NotEmpty(message="emp name should not be empty")
	@Size(min=3, max=15,message="emp name should be 3 to 15")
	private String empName;
	
	@Min(value=5000,message="emp salary should be min 5000")
	@Max(value=100000,message="emp salary should max 100000")
	@NotNull(message="emp salary should not be null")
	private Integer empSalary;

	public Integer getEmpId() {
		return empId;
	}
//
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
//
	public String getEmpName() {
		return empName;
	}
//
	public void setEmpName(String empName) {
		this.empName = empName;
	}
//
	public Integer getEmpSalary() {
		return empSalary;
	}
//
	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}
//	
	
}
