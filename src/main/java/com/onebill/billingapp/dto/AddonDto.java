package com.onebill.billingapp.dto;

import java.io.Serializable;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class AddonDto implements Serializable {
	private int addonId;
	private int documentId;
	private String documentType;
	private String documents;
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
}
