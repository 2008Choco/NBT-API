package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

/**
 * Represents an abstractified net.minecraft.server.NBTTagByteArray object. This
 * object acts as a compound with a single byte[] value associated with it
 * 
 * @author Parker Hawke - 2008Choco
 * 
 * @see NBTBasePrimitive
 */
public interface NBTBaseByteArray extends NBTBase {
	
	/**
	 * Get the byte[] value of this NBT object
	 * 
	 * @return the byte[] value
	 */
	public byte[] getValue();
	
}