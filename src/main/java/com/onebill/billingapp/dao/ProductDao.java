package com.onebill.billingapp.dao;

import java.util.List;

import com.onebill.billingapp.entities.Services;



public interface ProductDao {
//	public Company addCompany(Company company);

	public Services addService(Services service);

	public Services deleteService(int serviceId);
	
	public List<Services> getService(String companyName);
	
	public Services getService(int serviceId);
	
	public Services updateService(Services service);

//	public Company getCompany(int companyId);

//	public Company getCompany(String companyName);
	
	public List<Services> getServices(String serviceName);
	


	
}
