package com.onebill.billingapp.service;

import java.util.List;

import com.onebill.billingapp.entities.Services;

public interface ProductService {
	
	public Services addService(Services service);
	
	public Services deleteService(int serviceId);
	
	public Services getService(int serviceId);
	
	public Services updateService(Services service);
	
//	public Company getCompany(String companyName);
	
//	public Company getCompany(int companyId);
	
	public List<Services> getService(String companyName);
	
	public List<Services> getServices(String serviceName);
}
