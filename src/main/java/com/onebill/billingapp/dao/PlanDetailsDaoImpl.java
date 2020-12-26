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

import com.onebill.billingapp.entities.PlanDetails;
@Repository
public class PlanDetailsDaoImpl implements PlanDetailsDao{
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Transactional

	public PlanDetails createBundle(PlanDetails details) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(details);
		manager.getTransaction().commit();
		manager.close();
		return details;
	}
	
	public List<PlanDetails> getAllBundles() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<PlanDetails> query = manager.createQuery("FROM PlanDetails", PlanDetails.class);
		return query.getResultList();

	}

	public PlanDetails updateBundles(PlanDetails details) {
		EntityManager manager = factory.createEntityManager();
		PlanDetails details1 = manager.find(PlanDetails.class, details.getPlanDetailId());

		if (details1 != null) {
			BeanUtils.copyProperties(details, details1);
			manager.getTransaction().begin();
			manager.close();
			return details1;
		} else {
			manager.close();
			return null;
		}

	}

	public PlanDetails deleteBundle(int planDetailId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		PlanDetails details = manager.find(PlanDetails.class, planDetailId);
		manager.remove(details);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return details;

	}

}
