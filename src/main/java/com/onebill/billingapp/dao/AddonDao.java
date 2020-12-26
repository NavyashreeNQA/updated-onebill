package com.onebill.billingapp.dao;

import com.onebill.billingapp.entities.Addon;

public interface AddonDao {
public Addon addAddon(Addon addon);
	
	public Addon deleteAddon(int addonId);
	
	public Addon updateAddon(Addon addon);
	
	public Addon getAddons(int userId);
}
