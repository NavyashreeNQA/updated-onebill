package com.onebill.billingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billingapp.dao.PlanDetailsDao;
import com.onebill.billingapp.entities.PlanDetails;
import com.onebill.billingapp.exception.BillingAppException;

@Service
public class PlanDetailsImpl implements PlanDetailsService{
	@Autowired
	PlanDetailsDao planDetailsDao;

	public PlanDetails createBundle(PlanDetails details) {
		PlanDetails createBundle = null;
		try {
			createBundle=planDetailsDao.createBundle(details);
		
		if (createBundle != null) {
			return createBundle;
		} else {
			throw new BillingAppException("Unable to create bundle");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to create bundle");
		}
	}

	public List<PlanDetails> getAllBundles() {
		List<PlanDetails> getAllBundles = null;
		try {
			getAllBundles=planDetailsDao.getAllBundles();
		
		if (getAllBundles != null) {
			return getAllBundles;
		} else {
			throw new BillingAppException("Unable to fetch all bundles");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch all bundles");
		}
	}

	public PlanDetails updateBundle(PlanDetails details) {
		PlanDetails updateBundle = null;
		try {
			updateBundle=planDetailsDao.updateBundles(details);
		
		if (updateBundle != null) {
			return updateBundle;
		} else {
			throw new BillingAppException("Unable to update bundle");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to update bundle having id"+updateBundle.getPlanDetailId());
		}
	}

	public PlanDetails deleteBundle(int planDetailId) {
		PlanDetails deleteBundle = null;
		try {
			deleteBundle=planDetailsDao.deleteBundle(planDetailId);
		
		if (deleteBundle != null) {
			return deleteBundle;
		} else {
			throw new BillingAppException("Unable to remove bundle");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to remove bundle with id"+deleteBundle.getPlanDetailId());
		}
	}

}
