package com.onebill.billingapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billingapp.entities.Services;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Transactional
	public Services addService(Services service) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(service);
		manager.getTransaction().commit();

		return service;
		// @GetMapping("/{companyId}")
		// public ResponseDTO getCompany(@RequestBody int companyId) {
		// ResponseDTO response=new ResponseDTO();
		// response.setData(productService.getCompany(companyId));
		// return response;
		// }
	}

	public Services deleteService(int serviceId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Services service = manager.find(Services.class, serviceId);
		manager.remove(service);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return service;
	}

	// public Company addCompany(Company company) {
	// EntityManager manager = factory.createEntityManager();
	// EntityTransaction transaction = manager.getTransaction();
	// transaction.begin();
	// manager.persist(company);
	// manager.getTransaction().commit();
	// manager.close();
	// return company;
	//
	// }

	public Services getService(int serviceId) {
		EntityManager manager = factory.createEntityManager();
		Services query = manager.find(Services.class, serviceId);
		return query;

	}

	public Services updateService(Services service) {
		EntityManager manager = factory.createEntityManager();
		Services details1 = manager.find(Services.class, service.getServiceId());

		if (details1 != null) {
			BeanUtils.copyProperties(service, details1);
			manager.getTransaction().begin();
			manager.close();
			return details1;
		} else {
			manager.close();
			return null;
		}

	}

	// public Company getCompany(String companyName) {
	// EntityManager manager=factory.createEntityManager();
	// Company query=manager.find(Company.class,companyName);
	// return query;
	// }

	// public Company getCompany(int companyId) {
	// EntityManager manager = factory.createEntityManager();
	// Company query = manager.find(Company.class, companyId);
	// return query;
	// }

	public List<Services> getService(String companyName) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Services> query = manager.createQuery(
				"FROM Services U  JOIN Company C ON U.companyId =C.companyId WHERE C.companyName=:value",
				Services.class);
		query.setParameter("value", companyName);
		List<Services> serviceList = query.getResultList();
		List<Services> list = null;
		if (!serviceList.isEmpty()) {
			return serviceList;
		} else {
			return list;
		}
	}

	public List<Services> getServices(String serviceName) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Services> query = manager.createQuery("FROM Services U WHERE U.serviceName LIKE :value",
				Services.class);
		query.setParameter("value", "%" + serviceName + "%");
		return query.getResultList();

	}
}
