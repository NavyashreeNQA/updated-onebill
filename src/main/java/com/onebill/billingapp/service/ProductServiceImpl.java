package com.onebill.billingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billingapp.dao.ProductDao;
import com.onebill.billingapp.entities.Services;
import com.onebill.billingapp.exception.BillingAppException;



@Service

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	public Services addService(Services service) {
		Services service1 = null;
		try {
			service1 = productDao.addService(service);

			if (service1 != null) {
				return service1;
			} else {
				throw new BillingAppException("Unable to add service");
			}
		} catch (Exception e) {
			throw new BillingAppException("Unable to add" + " " + service.getServiceName() + "service please enter a valid service name");
		}
	}

	public Services deleteService(int serviceId) {
		Services deleteService = null;
		try {
			deleteService = productDao.deleteService(serviceId);

			if (deleteService != null) {
				return deleteService;
			} else {
				throw new BillingAppException("Unable to delete service");
			}
		} catch (Exception e) {
			throw new BillingAppException("Unable to delete service with the id"+deleteService.getServiceId());
		}
	}

	public Services getService(int serviceId) {
		Services getService =null;
		try {
			getService= productDao.getService(serviceId);
		
		if (getService != null) {
			return getService;
		} else {
			throw new BillingAppException("Unable to fetch a service");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch service with the id"+getService.getServiceId());
		}

	}

	public Services updateService(Services service) {
		Services getService = null;
		try {
		getService=productDao.updateService(service);
		if (getService != null) {
			return getService;
		} else {
			throw new BillingAppException("Unable to update a service");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to update service with the name"+getService.getServiceId());
		}
	}

	// public Company getCompany(String companyName) {
	// Company getCompany=productDao.getCompany(companyName);
	// if(getCompany!=null) {
	// return getCompany;
	// } else {
	// throw new BillingAppException("Unable to fetch company");
	// }
	// }

//	public Company getCompany(int companyId) {
//		Company getCompany = productDao.getCompany(companyId);
//		if (getCompany != null) {
//			return getCompany;
//		} else {
//			throw new BillingAppException("Unable to fetch company");
//		}
//	}

	public List<Services> getService(String companyName) {
		List<Services> getService = productDao.getService(companyName);
		if (getService != null) {
			return getService;
		} else {
			throw new BillingAppException("Unable to fetch all services");
		}	
	}

	
	public List<Services> getServices(String serviceName) {
		List<Services> getService = null;
		try {
			getService=productDao.getServices(serviceName);
		if (getService != null) {
			return getService;
		} else {
			throw new BillingAppException("Unable to fetch service for given name");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch service details");
		}
	}

}
