package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

/**
 * Represents an abstractified net.minecraft.server.NBTTagIntArray object. This
 * object acts as a compound with a single int[] value associated with it
 * 
 * @author Parker Hawke - 2008Choco
 * 
 * @see NBTBasePrimitive
 */
public interface NBTBaseIntArray extends NBTBase {
	
	/**
	 * Get the int[] value of this NBT object
	 * 
	 * @return the int[] value
	 */
	public int[] getValue();
	
}