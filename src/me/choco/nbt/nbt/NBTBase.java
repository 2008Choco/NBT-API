package me.choco.nbt.nbt;

import me.choco.nbt.utils.NBTModifiable;

/**
 * Represents the base of all NBT component objects. Can be modified
 * and placed on an {@link NBTModifiable} context
 * 
 * @author Parker Hawke - 2008Choco
 */
public abstract class NBTBase implements NBTModifiable { // More can probably be added here
	
	/**
	 * Whether the NBT value has any keys or not
	 * 
	 * @return true if there are no keys present
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Clone the NBTBase into a new object
	 */
	public abstract NBTBase clone();
	
	@Override
	public abstract boolean equals(Object tag);
	
	@Override
	public boolean isSupported() {
		return true;
	}
	
}