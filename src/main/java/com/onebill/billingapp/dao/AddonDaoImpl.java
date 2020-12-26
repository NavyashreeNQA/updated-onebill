package com.onebill.billingapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billingapp.entities.Addon;

@Repository
public class AddonDaoImpl implements AddonDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Transactional

	public Addon addAddon(Addon addon) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(addon);
		manager.getTransaction().commit();
		manager.close();
		return addon;

	}

	public Addon deleteAddon(int addonId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Addon addon = manager.find(Addon.class, addonId);
		manager.remove(addon);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return addon;

	}

	public Addon updateAddon(Addon addon) {
		EntityManager manager = factory.createEntityManager();
		Addon addon1 = manager.find(Addon.class, addon.getAddonId());

		if (addon1 != null) {
			BeanUtils.copyProperties(addon, addon1);
			manager.getTransaction().begin();
			manager.close();
			return addon1;
		} else {
			manager.close();
			return null;
		}

	}

	public Addon getAddons(int userId) {
		EntityManager manager = factory.createEntityManager();
		Addon query = manager.find(Addon.class, userId);
		return query;

	}

}
