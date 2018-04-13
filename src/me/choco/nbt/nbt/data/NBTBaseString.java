package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

/**
 * Represents an abstractified net.minecraft.server.NBTTagString object. This
 * object acts as a compound with a single String value associated with it
 * 
 * @author Parker Hawke - 2008Choco
 * 
 * @see NBTBasePrimitive
 */
public interface NBTBaseString extends NBTBase {
	
	/**
	 * Get the String value of this NBT object
	 * 
	 * @return the string value
	 */
	public String getValue();
	
}