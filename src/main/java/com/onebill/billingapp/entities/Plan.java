package com.onebill.billingapp.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="plan_id")
	private int planId;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="plan_name",unique=true)
	private String planName;
	
	@Column(name="plan_validity")
	private String planValidity;
	
	@Column(name="plan_data")
	private String data;
	
	@Column(name="plan_amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="service_id")
	@NotNull
	private Services service;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER, mappedBy = "plan")
    private Set<Addon> addon;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER, mappedBy = "plan")
    private Set<Charges> charges;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER, mappedBy = "plan")
    private List<PlanDetails> details;


	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanValidity() {
		return planValidity;
	}

	public void setPlanValidity(String planValidity) {
		this.planValidity = planValidity;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
}
