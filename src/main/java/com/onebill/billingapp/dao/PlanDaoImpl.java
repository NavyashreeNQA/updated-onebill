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

import com.onebill.billingapp.entities.Plan;

@Repository
public class PlanDaoImpl implements PlanDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Transactional

	public Plan addPlan(Plan plan) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(plan);
		manager.getTransaction().commit();
		manager.close();
		return plan;
	}

	public Plan updatePlan(Plan plan) {
		EntityManager manager = factory.createEntityManager();
		Plan plan1 = manager.find(Plan.class, plan.getPlanId());

		if (plan1 != null) {
			BeanUtils.copyProperties(plan, plan1);
			manager.getTransaction().begin();
			manager.close();
			return plan1;
		} else {
			manager.close();
			return null;
		}
	}

	public List<Plan> getAllPlan() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Plan> query = manager.createQuery("FROM Plan", Plan.class);
		return query.getResultList();
	}

	public Plan removePlan(int planId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Plan plan = manager.find(Plan.class, planId);
		manager.remove(plan);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return plan;
	}

	public Plan getPlan(int planId) {
		EntityManager manager = factory.createEntityManager();
		Plan query = manager.find(Plan.class, planId);
		return query;
	}

	
	public List<Plan> getPlan(String planName) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Plan> query = manager.createQuery("FROM Plan U WHERE U.planName =:value", Plan.class);
		query.setParameter("value", planName);
		List<Plan> planList = query.getResultList();
		List<Plan> list = null;
		if (!planList.isEmpty()) {
			return planList;
		} else {
			return list;
		}

	}

	
	public List<Plan> getPlans(String planName) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Plan> query = manager.createQuery("FROM Plan U WHERE U.planName LIKE :value",
				Plan.class);
		query.setParameter("value", "%" + planName + "%");
		return query.getResultList();

	}
}
