package me.choco.nbt;

import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.nbt.NBTList;
import me.choco.nbt.nbt.data.NBTBasePrimitive;
import me.choco.nbt.nbt.data.NBTBaseString;
import me.choco.nbt.nbt.data.NBTDataType;
import me.choco.nbt.types.NBTItem;

import org.bukkit.inventory.ItemStack;

public interface NBTAPI {
	
	/**
	 * Create a new empty {@link NBTCompound} object
	 * 
	 * @return the newly created compound
	 */
	public NBTCompound newNBTCompound();
	
	/**
	 * Create a new empty {@link NBTList} object
	 * 
	 * @return the newly created list
	 */
	public NBTList newNBTList();
	
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
	public <T> NBTBase createNBTBase(NBTDataType<T> type, T value);
	
	/**
	 * Get the NBT modifiable equivalent of an ItemStack
	 * 
	 * @param item the item to modify
	 * @return an ItemStack with modifiable NBT
	 */
	public NBTItem getNBTItem(ItemStack item);
	
}