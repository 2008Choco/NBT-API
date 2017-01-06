package me.choco.nbt;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.choco.nbt.types.NBTItem;
import me.choco.nbt.utils.NBTModifiable;
import me.choco.nbt.utils.ReflectionUtils;

public class NBTAPI extends JavaPlugin {
	
	private String bukkitVersion;
	
	@Override
	public void onEnable() {
		this.getLogger().info("Retrieving Bukkit version information");
		bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		this.getLogger().info("Bukkit implementation " + this.bukkitVersion);
		
		ReflectionUtils.loadNMSClasses();
	}
	
	public String getBukkitVersion() {
		return bukkitVersion;
	}
	
	public static NBTModifiable<ItemStack> getNBTItem(ItemStack item) {
		NBTItem nbtItem = new NBTItem(item);
		if (nbtItem.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable ItemStack");
		
		return nbtItem;
	}
}