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
import com.onebill.billingapp.entities.Addon;
import com.onebill.billingapp.service.AddonService;

@RestController
@RequestMapping("/addons")
@CrossOrigin("*")
public class AddonController {
	@Autowired
	private AddonService addonService;
	
	@PostMapping("/addon")
	public ResponseDTO addAddon(@RequestBody Addon addon) {
		ResponseDTO response=new ResponseDTO();
		response.setData(addonService.addAddon(addon));
		return response;
	}
	
	@PutMapping("/manage-addon")
	public ResponseDTO updateCharges(@RequestBody Addon addon) {
		ResponseDTO response=new ResponseDTO();
		response.setData(addonService.updateAddon(addon));
		return response;
	}
	
	@DeleteMapping("/info/{addonId}")
	public ResponseDTO removeAddon(@PathVariable int addonId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(addonService.deleteAddon(addonId));
		return response;
	}
	
	@GetMapping("/{userId}")
	public ResponseDTO getPLan(@PathVariable int userId) {
		ResponseDTO response=new ResponseDTO();
		response.setData(addonService.getAddons(userId));
		return response;
	}


}
