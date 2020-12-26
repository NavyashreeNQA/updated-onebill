package com.onebill.billingapp.dto;

import java.io.Serializable;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class PlanDetails implements Serializable {
	private int planDetailId;
	private String planType;
	private String details;
	public int getPlanDetailId() {
		return planDetailId;
	}
	public void setPlanDetailId(int planDetailId) {
		this.planDetailId = planDetailId;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
