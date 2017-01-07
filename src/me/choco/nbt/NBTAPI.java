package me.choco.nbt;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.choco.nbt.commands.ItemNBTCmd;
import me.choco.nbt.types.NBTEntity;
import me.choco.nbt.types.NBTItem;
import me.choco.nbt.types.NBTTileEntity;
import me.choco.nbt.utils.ReflectionUtils;

/**
 * An extensive NBT library to allow for easy custom modifications to
 * existing ItemStack, Entity and TileEntity objects. NBT data is managed
 * by the server, and this API is meant to interface with it and simplify
 * accessing net.minecraft.server methods.
 * <br>
 * <br> This library uses reflection, and will hardly require updates - if
 * any at all. The goal of this plugin is to allow for interaction with custom
 * NBT data, yet simultaneously maintain high performance.
 * 
 * @author Parker Hawke - 2008Choco
 * @author Contributor - iso2013
 */
public class NBTAPI extends JavaPlugin {
	
	/* TODO:
	 *   - NBTEntity method bodies
	 *   - NBTTileEntity method bodies
	 *   - Implement bStats ( http://www.bstats.org )
	 *   - Write proper commands to modify NBT data for Entity, TileEntity and ItemStack objects (i.e. not the onCommand() down below)
	 */
	
	// Bukkit implementation, (ex: 1_11_R1)
	private String bukkitVersion;
	
	@Override
	public void onEnable() {
		// Reflection loading
		this.getLogger().info("Retrieving Bukkit version information");
		bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		this.getLogger().info("Bukkit implementation " + this.bukkitVersion);
		
		ReflectionUtils.loadNMSClasses(this.bukkitVersion);
		
		// Command registration
		this.getCommand("itemnbt").setExecutor(new ItemNBTCmd());
		
		// TODO: new Metrics(this);
	}
	
	/**
	 * Get the Bukkit implementation version for the current server (i.e. 1_11_R1)
	 * 
	 * @return Bukkit implementation version
	 */
	public String getBukkitVersion() {
		return bukkitVersion;
	}
	
	/**
	 * Get the NBT modifiable equivalent of an ItemStack
	 * 
	 * @param item - The item to modify
	 * @return a modifiable item stack
	 */
	public static NBTItem getNBTItem(ItemStack item) {
		NBTItem nbtItem = new NBTItem(item);
		if (!nbtItem.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable ItemStack");
		
		return nbtItem;
	}
	
	/**
	 * Get the NBT modifiable equivalent of an Entity
	 * 
	 * @param entity - The entity to modify
	 * @return a modifiable entity
	 */
	public static NBTEntity getNBTEntity(Entity entity) {
		NBTEntity nbtEntity = new NBTEntity(entity);
		if (!nbtEntity.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable Entity");
		
		return nbtEntity;
	}
	
	/**
	 * Get the NBT modifiable equivalent of a Tile Entity (BlockState)
	 * 
	 * @param blockState - The tile entity (block state) to modify
	 * @return a modifiable tile entity
	 */
	public static <T extends BlockState> NBTTileEntity<T> getNBTTileEntity(T blockState) {
		NBTTileEntity<T> nbtTileEntity = new NBTTileEntity<>(blockState);
		if (!nbtTileEntity.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable TileEntity");
		
		return nbtTileEntity;
	}
	
}