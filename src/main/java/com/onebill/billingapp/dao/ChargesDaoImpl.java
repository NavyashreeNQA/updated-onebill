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

import com.onebill.billingapp.entities.Charges;
@Repository
public class ChargesDaoImpl implements ChargesDao{
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Transactional

	public Charges updateCharges(Charges charges) {
		EntityManager manager = factory.createEntityManager();
		Charges charge1 = manager.find(Charges.class, charges.getChargeId());

		if (charge1 != null) {
			BeanUtils.copyProperties(charges, charge1);
			manager.getTransaction().begin();
			manager.close();
			return charge1;
		} else {
			manager.close();
			return null;
		}

	}
	
	public Charges addCharges(Charges charges) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(charges);
		manager.getTransaction().commit();
		manager.close();
		return charges;
	}

	public Charges getCharge(int chargeId) {
		EntityManager manager = factory.createEntityManager();
		 Charges query = manager.find(Charges.class, chargeId);
		 return query;	
	}
	
	public Charges deleteCharge(int chargeId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Charges charge = manager.find(Charges.class, chargeId);
		manager.remove(charge);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return charge;

	}


	public List<Charges> getCharges(String chargeType) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Charges> query = manager.createQuery("FROM Charges U WHERE U.chargeType LIKE :value",
				Charges.class);
		query.setParameter("value", "%" + chargeType + "%");
		return query.getResultList();

	}


}
