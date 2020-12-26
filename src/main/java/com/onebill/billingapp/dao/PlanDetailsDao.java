package com.onebill.billingapp.dao;

import java.util.List;

import com.onebill.billingapp.entities.PlanDetails;

public interface PlanDetailsDao {
	public PlanDetails createBundle(PlanDetails details);
	
	public List<PlanDetails> getAllBundles();
	
	public PlanDetails updateBundles(PlanDetails details);
	
	public PlanDetails deleteBundle(int planDetailId);

}
