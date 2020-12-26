package com.onebill.billingapp.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private boolean error;
	private Object data;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
