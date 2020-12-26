package com.onebill.billingapp.service;

import java.util.List;

import com.onebill.billingapp.entities.PlanDetails;

public interface PlanDetailsService {
public PlanDetails createBundle(PlanDetails details);
	
	public List<PlanDetails> getAllBundles();
	
	public PlanDetails updateBundle(PlanDetails details);
	
	public PlanDetails deleteBundle(int planDetailId);
	
}
