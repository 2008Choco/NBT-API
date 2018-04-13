package me.choco.nbt.types;

import me.choco.nbt.nbt.NBTModifiable;

import org.bukkit.entity.Entity;

/**
 * An Entity object with modifiable NBT data
 * 
 * @param <T> the type of entity being modified
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface NBTEntity<T extends Entity> extends NBTModifiable {
	
	/**
	 * Get the Entity instance being modified
	 * 
	 * @return the entity
	 */
	public T getEntity();
	
	/**
	 * Save any NBT to this entity. This method MUST be called in order for any
	 * changes made to the entity's NBT to be applied.
	 */
	public void saveNBT();
	
}