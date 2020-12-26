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
import com.onebill.billingapp.entities.Plan;
import com.onebill.billingapp.service.PlanService;
@RestController
@RequestMapping("/productplan")
@CrossOrigin("*")
public class PlanController {
	@Autowired
	private PlanService planService;
	
	@PostMapping("/plan")
	public ResponseDTO addPlan(@RequestBody Plan plan) {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.addPlan(plan));
		return response;
	}
	
	@PutMapping("/manage-plan")
	public ResponseDTO updatePlan(@RequestBody Plan plan) {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.updatePlan(plan));
		return response;
	}
	
	@GetMapping("/plans")
	public ResponseDTO getAllPlan() {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.getAllPlan());
		return response;
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseDTO removePlan(@PathVariable int planId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.removePlan(planId));
		return response;
	}
	
	@GetMapping("/plans/{planId}")
	public ResponseDTO getPlan(@PathVariable int planId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.getPlan(planId));
		return response;
	}
	
//	@GetMapping("/{planName}")
//	public ResponseDTO getPlan(@PathVariable String planName) {
//		ResponseDTO response=new ResponseDTO();
//		response.setData(planService.getPlan(planName));
//		return response;
//	}
	
	@GetMapping("/{planName}")
	public ResponseDTO getPlans(@PathVariable String planName) {
		ResponseDTO response=new ResponseDTO();
		response.setData(planService.getPlans(planName));
		return response;
	}
}
