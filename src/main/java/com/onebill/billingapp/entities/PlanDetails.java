package com.onebill.billingapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PlanDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="plandetail_id")
	private int planDetailId;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="details")
	private String details;
	
	@ManyToOne
	@JoinColumn(name="plan_id")
	private Plan plan;

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

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
