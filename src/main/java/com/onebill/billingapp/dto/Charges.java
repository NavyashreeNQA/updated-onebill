package com.onebill.billingapp.dto;

import java.io.Serializable;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class Charges implements Serializable {
	private int chargeId;
	private String chargeType;
	private String chargeFor;
	private double charge;
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
}
