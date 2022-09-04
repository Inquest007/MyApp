package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ErrorRespDTO {
	
	public ErrorRespDTO(List<String> error, Integer respCode) {
		this.error = error;
		this.respCode = respCode;
	}
	private List<String> error;
	private Integer respCode;
	public List<String> getError() {
		return error;
	}
	public void setError(List<String> error) {
		this.error = error;
	}
	public Integer getRespCode() {
		return respCode;
	}
	public void setRespCode(Integer respCode) {
		this.respCode = respCode;
	}
	
	
}
