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
import com.onebill.billingapp.entities.PlanDetails;
import com.onebill.billingapp.service.PlanDetailsService;

@RestController
@RequestMapping("/plandetails")
@CrossOrigin("*")
public class PlanDetailsController {
	@Autowired
	private PlanDetailsService companyService;
	

	@PostMapping("/bundle")
	public ResponseDTO createBundle(@RequestBody PlanDetails details) {
		ResponseDTO response = new ResponseDTO();
		response.setData(companyService.createBundle(details));
		return response;
	}

	@GetMapping("/bundles")
	public ResponseDTO getAllBundles() {
		ResponseDTO response = new ResponseDTO();
		response.setData(companyService.getAllBundles());
		return response;
	}

	@PutMapping("/manage-bundle")
	public ResponseDTO updateBundle(@RequestBody PlanDetails details) {
		ResponseDTO response = new ResponseDTO();
		response.setData(companyService.updateBundle(details));
		return response;
	}

	@DeleteMapping("/bundle/{planDetailId}")
	public ResponseDTO deleteBundle(@PathVariable int planDetailId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(companyService.deleteBundle(planDetailId));
		return response;
	}
	
	

}
