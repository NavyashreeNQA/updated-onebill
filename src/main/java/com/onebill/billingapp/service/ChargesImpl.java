package com.onebill.billingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billingapp.dao.ChargesDao;
import com.onebill.billingapp.entities.Charges;
import com.onebill.billingapp.exception.BillingAppException;
@Service
public class ChargesImpl implements ChargesService{
	@Autowired
	ChargesDao companyDao;
	
	public Charges addCharges(Charges charges) {
		Charges addCharges=null;
		try {
			addCharges=companyDao.addCharges(charges);
		
		if(addCharges!=null) {
			return addCharges;
		} else {
			throw new BillingAppException("Unable to add charges");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to add charges");
		}
	}

	
	public Charges updateCharges(Charges charges) {
		Charges updateCharges=null;
		try {
			updateCharges=companyDao.updateCharges(charges);
		if(updateCharges!=null) {
			return updateCharges;
		} else {
			throw new BillingAppException("Unable to update charge");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to update charge with id"+updateCharges.getChargeId());
		}
	}


	public Charges getCharge(int chargeId) {
		Charges getCharge = null;
		try {
			getCharge=companyDao.getCharge(chargeId);
		if(getCharge!=null) {
			return getCharge;
		} else {
			throw new BillingAppException("Unable to fetch charge details");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch charge details with id"+getCharge.getChargeId());
		}

	}


	public Charges deleteCharge(int chargeId) {
		Charges deleteCharge = null;
		try {
			deleteCharge=companyDao.deleteCharge(chargeId);
		if (deleteCharge != null) {
			return deleteCharge;
		} else {
			throw new BillingAppException("Unable to delete ");
		}
		}catch(Exception e) {
			throw new BillingAppException("unable to delete charge with id"+deleteCharge.getChargeId());
		}
	}


	
	public List<Charges> getCharges(String chargeType) {
		List<Charges> getCharges = null;
		try {
			getCharges=companyDao.getCharges(chargeType);
		if(getCharges!=null) {
			return getCharges;
		} else {
			throw new BillingAppException("Unable to fetch  charges details");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch charges details with the given charge type"+getCharges);
		}

	}

}
