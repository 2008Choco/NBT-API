package me.choco.nbt.nbt;

/**
 * Represents the base of all NBT component objects. Can be modified
 * and placed on an {@link NBTModifiable} context
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface NBTBase extends Cloneable {
	
	/**
	 * Whether the NBT value has any keys or not
	 * 
	 * @return true if there are no keys present
	 */
	public boolean isEmpty();
	
	/**
	 * Mirror this NBT abstraction to its NMS counterpart
	 * 
	 * @return the NMS mirror
	 */
	public Object toNMS();
	
	public NBTBase clone();
	
}