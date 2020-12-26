package com.onebill.billingapp.dao;

import java.util.List;

import com.onebill.billingapp.entities.Plan;

public interface PlanDao {
	public Plan addPlan(Plan plan);

	public Plan updatePlan(Plan plan);

	public List<Plan> getAllPlan();

	public Plan removePlan(int planId);
	
	public Plan getPlan(int planId);

	public List<Plan> getPlan(String planName);
	
	public List<Plan> getPlans(String planName);
}
