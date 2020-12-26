package com.onebill.billingapp.service;

import com.onebill.billingapp.entities.Addon;

public interface AddonService {
	public Addon addAddon(Addon addon);
	
	public Addon deleteAddon(int addonId);
	
	public Addon updateAddon(Addon addon);
	
	public Addon getAddons(int userId);
}
