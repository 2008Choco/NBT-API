package me.choco.nbt.utils;

import me.choco.nbt.nbt.NBTModifiable;

/**
 * An application interface to apply key-value pairs to {@link NBTModifiable} instances
 * 
 * @author Parker Hawke - 2008Choco
 * @param <T> the required data type for the data application
 */
@FunctionalInterface
public interface Applier<T> {
	
	/**
	 * Apply a key-value pair to the provided NBTModifiable instance
	 * 
	 * @param nbtModifiable the NBTModifiable object to which data should be applied
	 * @param key the key to set
	 * @param value the value to set
	 */
	public void apply(NBTModifiable nbtModifiable, String key, T value);
	
}