package me.choco.nbt;

import me.choco.nbt.commands.ItemNBTCmd;
import me.choco.nbt.impl.v1_12_R1.NBTUtils1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.nbt.NBTList;
import me.choco.nbt.nbt.data.NBTBasePrimitive;
import me.choco.nbt.nbt.data.NBTBaseString;
import me.choco.nbt.nbt.data.NBTDataType;
import me.choco.nbt.types.NBTItem;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * An extensive NBT library to allow for easy custom modifications to
 * existing ItemStack, Entity and TileEntity objects. NBT data is managed
 * by the server, and this API is meant to interface with it and simplify
 * accessing net.minecraft.server methods.
 * <p>
 * This library uses version abstraction, and will require frequent updates
 * The goal of this plugin is to allow for interaction with custom NBT data,
 * yet simultaneously maintain high performance.
 * 
 * @author Parker Hawke - 2008Choco
 * @author Contributor - iso2013
 */
public class NBTAPIPlugin extends JavaPlugin {
	
	/* TODO:
	 *   - Implement bStats ( http://www.bstats.org )
	 *   - Add abstraction for byte[] and other missing data types
	 *   - Write implementations for other versions
	 */
	
	private static NBTAPI api;
	
	// Bukkit implementation, (ex: 1_12_R1)
	private String bukkitVersion;
	
	@Override
	public void onEnable() {
		// Reflection loading
		this.getLogger().info("Retrieving Bukkit version information");
		this.bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		this.setupAbstractionUtils();
		this.getLogger().info("Bukkit implementation " + bukkitVersion);
		
		// Command registration
		this.getCommand("itemnbt").setExecutor(new ItemNBTCmd());
		
		// TODO: new Metrics(this);
	}
	
	/**
	 * Get the Bukkit implementation version for the current server (i.e. 1_12_R1)
	 * 
	 * @return Bukkit implementation version
	 */
	public String getBukkitVersion() {
		return bukkitVersion;
	}
	
	/**
	 * Create a new empty {@link NBTCompound} object
	 * 
	 * @return the newly created compound
	 */
	public static NBTCompound newNBTCompound() {
		return api.newNBTCompound();
	}
	
	/**
	 * Create a new empty {@link NBTList} object
	 * 
	 * @return the newly created list
	 */
	public static NBTList newNBTList() {
		return api.newNBTList();
	}
	
	/**
	 * Create an NBTBase object with a set value. The created instance may
	 * be an instance of any one of the base tags listed in {@link NBTDataType}
	 * 
	 * @param type the type of NBT base to create
	 * @param value the initial value to set in the base
	 * 
	 * @return the created NBTBase instance. null if invalid type specified
	 * 
	 * @see NBTBasePrimitive
	 * @see NBTBaseString
	 * @see NBTCompound
	 * @see NBTList
	 */
	public static <T> NBTBase createNBTBase(NBTDataType<T> type, T value) {
		return api.createNBTBase(type, value);
	}
	
	/**
	 * Get the NBT modifiable equivalent of an ItemStack
	 * 
	 * @param item the item to modify
	 * @return a modifiable item stack
	 */
	public static NBTItem getNBTItem(ItemStack item) {
		return api.getNBTItem(item);
	}
	
	/**
	 * Get an instance of the NBTAPI class
	 * 
	 * @return the NBTAPI instance
	 */
	public static NBTAPI getAPI() {
		return api;
	}
	
	private void setupAbstractionUtils() {
		if (api != null) return;
		
		switch (bukkitVersion) {
			case "v1_12_R1": api = new NBTUtils1_12_R1(); break;
		}
	}
	
}