package com.minehut.daemon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.minehut.daemon.protocol.addon.Addon;
import com.minehut.daemon.tools.mc.MCPlayer;

public class Kingdom {
	
	private MCPlayer owner;
	
	public int id = 0;
	
	private SampleKingdom sampleBase;
	public boolean featured = false;
	private String homeDir, playerFolder, name;
	
	private List<Addon> addonList = new ArrayList<Addon>();
	
	public Kingdom(MCPlayer owner, SampleKingdom sample, int id) {
		this.owner = owner;
		this.sampleBase = sample;
		this.id = id;
		this.playerFolder = "./kingdoms/" + owner.playerUUID;
		this.homeDir = "./kingdoms/" + owner.playerUUID + "/kingdom" + id;
		
		this.initPlayerFolder();
	}
	
	public Kingdom(MCPlayer owner, SampleKingdom sample) {
		this.owner = owner;
		this.sampleBase = sample;
		this.playerFolder = "./kingdoms/" + owner.playerUUID;
		this.homeDir = "./kingdoms/" + owner.playerUUID + "/kingdom" + id;
		
		this.initPlayerFolder();
	}
	
	public void setSampleKingdom(SampleKingdom sample) {
		this.sampleBase = sample;
	}
	
	public void removeAddon(Addon addon) {
		this.addonList.remove(addon);
	}
	
	public void addAddon(Addon addon) {
		this.addonList.add(addon);
	}
	
	public List<Addon> getAddons() {
		return this.addonList;
	}
	
	public MCPlayer getOwner() {
		return this.owner;
	}
	
	public String getHomeDir() {
		return this.homeDir;
	}
	
	public SampleKingdom getSampleKingdom() {
		return this.sampleBase;
	}
	
	private void initPlayerFolder() {
		if (!this.hasPlayerFolder())
			new File(playerFolder).mkdir();
	}
	
	public boolean hasPlayerFolder() {
		return new File(playerFolder).exists();
	}
	
	public boolean isInstalled() {
		return new File(homeDir).exists();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
