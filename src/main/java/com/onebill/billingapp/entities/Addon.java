package com.onebill.billingapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Addon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addon_id")
	private int addonId;
	
	@Column(name="document_id")
	private int documentId;
	
	@Column(name="document_type")
	private String documentType;
	
	@Column(name="documents")
	private String documents;
	
	@JsonIgnore
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="plan_id")
	private Plan plan;
	
	@JsonIgnore
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	public int getAddonId() {
		return addonId;
	}

	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
