package me.choco.nbt;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.choco.nbt.types.NBTItem;
import me.choco.nbt.utils.NBTModifiable;

public class NBTAPI extends JavaPlugin {
	
	private String bukkitVersion;
	
	@Override
	public void onEnable() {
		this.getLogger().info("Retrieving Bukkit version information");
		bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		this.getLogger().info("Bukkit implementation " + this.bukkitVersion);
	}
	
	public String getBukkitVersion() {
		return bukkitVersion;
	}
	
	public static NBTModifiable<ItemStack> getNBTItem(ItemStack item) {
		return new NBTItem(item);
	}
}