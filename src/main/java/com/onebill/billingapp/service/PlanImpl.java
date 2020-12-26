package com.onebill.billingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billingapp.dao.PlanDao;
import com.onebill.billingapp.entities.Plan;
import com.onebill.billingapp.entities.Services;
import com.onebill.billingapp.exception.BillingAppException;
@Service
public class PlanImpl implements PlanService{
	@Autowired
	PlanDao planDao;
	
	public Plan addPlan(Plan plan) {
		Plan addPlan=null;
		Services serviceId=null;
		try {
			addPlan=planDao.addPlan(plan);
		if(addPlan!=null && serviceId!=null) {
			return addPlan;
		} else {
			throw new BillingAppException("Unable to add plan");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to add plan");
		}
	}
	
	
	public Plan updatePlan(Plan plan) {
		Plan updatePlan=null;
		try {
			updatePlan=planDao.updatePlan(plan);
		if(updatePlan!=null) {
			return updatePlan;
		} else {
			throw new BillingAppException("Unable to update plan");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to update plan with plan id"+updatePlan.getPlanId());
		}
	}
	
	
	public List<Plan> getAllPlan() {
		List<Plan> getAllPlan = null;
		try {
			getAllPlan=planDao.getAllPlan();
		if(getAllPlan!=null) {
			return getAllPlan;
		} else {
			throw new BillingAppException("Unable to fetch all plans");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch all the plans details");
		}
	}
	
	
	public Plan removePlan(int planId) {
		Plan removePlan=null;
		try {
			removePlan=planDao.removePlan(planId);
		
		if(removePlan!=null) {
			return removePlan;
		} else {
			throw new BillingAppException("Unable to remove plan");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to remove plan with plan id"+removePlan.getPlanId());
		}
	}
	
	public Plan getPlan(int planId) {
		Plan getPlan = null;
		try {
			getPlan=planDao.getPlan(planId);
		if(getPlan!=null) {
			return getPlan;
		} else {
			throw new BillingAppException("Unable to fetch a plan");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch a plan with plan id"+getPlan.getPlanId());
		}
	}


	
	public List<Plan> getPlan(String planName) {
		List<Plan> getPlan = null;
		try {
			getPlan=planDao.getPlan(planName);
		if(getPlan!=null) {
			return getPlan;
		} else {
			throw new BillingAppException("Unable to fetch  plan");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch plan with the given name"+getPlan);
		}

	}


	
	public List<Plan> getPlans(String planName) {
		List<Plan> getPlan = null;
		try {
			getPlan=planDao.getPlans(planName);
		if(getPlan!=null) {
			return getPlan;
		} else {
			throw new BillingAppException("Unable to fetch  plan");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch plan having name"+getPlan);
		}

	}
	
}
