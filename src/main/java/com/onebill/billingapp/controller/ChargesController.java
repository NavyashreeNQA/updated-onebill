package com.onebill.billingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.billingapp.dto.ResponseDTO;
import com.onebill.billingapp.entities.Charges;
import com.onebill.billingapp.service.ChargesService;
import com.onebill.billingapp.service.PlanService;

@RestController
@RequestMapping("/charges")
@CrossOrigin("*")
public class ChargesController {
	
	@Autowired
	private ChargesService chargesService;
	private PlanService planService;
	
	@PostMapping("/charge")
	public ResponseDTO addCharges(@RequestBody Charges charges) {
		ResponseDTO response=new ResponseDTO();
		response.setData(chargesService.addCharges(charges));
		return response;
	}
	
	@PutMapping("/manage-charges")
	public ResponseDTO updateCharges(@RequestBody Charges charges) {
		ResponseDTO response=new ResponseDTO();
		response.setData(chargesService.updateCharges(charges));
		return response;
	}
	
	@GetMapping("/{chargeId}")
	public ResponseDTO getCharges(@PathVariable int chargeId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(chargesService.getCharge(chargeId));
		return response;
	}
	
	@DeleteMapping("/info/{chargeId}")
	public ResponseDTO deleteCharge(@PathVariable int chargeId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(chargesService.deleteCharge(chargeId));
		return response;
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseDTO getPlan(@PathVariable int planId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.getPlan(planId));	
		return response;
	}
	
	@GetMapping("/charge/{chargeType}")
	public ResponseDTO getCharges(@PathVariable String chargeType) {
		ResponseDTO response=new ResponseDTO();
		response.setData(chargesService.getCharges(chargeType));	
		return response;
	}


	
}
