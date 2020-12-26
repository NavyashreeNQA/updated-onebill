package com.onebill.billingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billingapp.dao.AddonDao;
import com.onebill.billingapp.entities.Addon;
import com.onebill.billingapp.exception.BillingAppException;

@Service
public class AddonImpl implements AddonService {
	@Autowired
	private AddonDao addonDao;

	public Addon addAddon(Addon addon) {
		Addon addAddon = null;
		try {
			addAddon=addonDao.addAddon(addon);
		
		if (addAddon != null) {
			return addAddon;
		} else {
			throw new BillingAppException("Unable to add addons");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to add addons");
		}
	}

	public Addon deleteAddon(int addonId) {
		Addon deleteAddon = null;
		try {
			deleteAddon=addonDao.deleteAddon(addonId);
		
		if (deleteAddon != null) {
			return deleteAddon;
		} else {
			throw new BillingAppException("Unable to delete addons");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to delete addons with id"+deleteAddon.getAddonId());
		}
	}

	public Addon updateAddon(Addon addon) {
		Addon updateAddon = null;
		try {
			updateAddon=addonDao.updateAddon(addon);
		
		if (updateAddon != null) {
			return updateAddon;
		} else {
			throw new BillingAppException("Unable to update addons");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to update addons");
		}
	}

	public Addon getAddons(int userId) {
		Addon getAddon = null;
		try {
			getAddon=addonDao.getAddons(userId);
		if (getAddon != null) {
			return getAddon;
		} else {
			throw new BillingAppException("Unable to fetch addons");
		}
		}catch(Exception e) {
			throw new BillingAppException("Unable to fetch addons");
		}
	}

}
