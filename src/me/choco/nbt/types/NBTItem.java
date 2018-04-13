package me.choco.nbt.types;

import me.choco.nbt.nbt.NBTModifiable;

import org.bukkit.inventory.ItemStack;

/**
 * An ItemStack object with modifiable NBT data
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface NBTItem extends NBTModifiable {
	
	/**
	 * Get the ItemStack instance with the modified NBT compounds
	 * 
	 * @return the modified NBT tags
	 */
	public ItemStack getModifiedItemStack();
	
}