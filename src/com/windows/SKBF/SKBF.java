package com.windows.SKBF;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.windows.API.API;

public class SKBF extends JavaPlugin implements Listener{

	API api;
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		if (getServer().getPluginManager().getPlugin("API") == null) {
			Bukkit.getConsoleSender().sendMessage("§e[!] API 플러그인이 존재하지 않습니다. 플러그인을 종료합니다.");
			Bukkit.getPluginManager().disablePlugin(this);
		} else {
			Bukkit.getConsoleSender().sendMessage("§e[WINDOWS] §a샵키퍼 버그차단 플러그인 활성화");
			api = (API) Bukkit.getPluginManager().getPlugin("API");
		}
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§e[WINDOWS] §c샵키퍼 버그차단 플러그인 비활성화");
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	private void onClick(InventoryClickEvent event) {
		if (event.getInventory().getType().toString() == ("MERCHANT") && event.getAction().name().toString() == ("COLLECT_TO_CURSOR")) {
				event.setCancelled(true);
				event.setResult(Result.DENY);
		}
		if (event.getInventory().getType().toString() == ("MERCHANT") && event.getAction().name().toString() == ("MOVE_TO_OTHER_INVENTORY")) {
			event.setCancelled(true);
			event.setResult(Result.DENY);
		}
	}
	
}
