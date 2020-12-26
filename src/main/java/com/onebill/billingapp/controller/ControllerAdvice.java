package com.onebill.billingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onebill.billingapp.dto.ResponseDTO;
import com.onebill.billingapp.exception.BillingAppException;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(BillingAppException.class)
	public ResponseEntity<ResponseDTO> handler(BillingAppException e) {
		ResponseDTO response = new ResponseDTO();
		response.setError(true);
		response.setData(e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
