package com.onebill.billingapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Data
@Entity
public class Charges {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="charge_id")
	private int chargeId;
	
	@Column(name="charge_type")
	private String chargeType;
	
	@Column(name="charge_frequency")
	private String chargeFrequency;
	
	@Column(name="charge_for")
	private String chargeFor;
	
	@Column(name="charge")
	private double charge;
	
	
	@ManyToOne
	@JoinColumn(name="plan_id")
	private Plan plan;

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getChargeFrequency() {
		return chargeFrequency;
	}

	public void setChargeFrequency(String chargeFrequency) {
		this.chargeFrequency = chargeFrequency;
	}

	public String getChargeFor() {
		return chargeFor;
	}

	public void setChargeFor(String chargeFor) {
		this.chargeFor = chargeFor;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	}

	
