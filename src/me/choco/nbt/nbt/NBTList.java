package me.choco.nbt.nbt;

/**
 * Represents an abstractified net.minecraft.server.NBTTagList object
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface NBTList extends NBTBase {
	
	/**
	 * Get the size of this list
	 * 
	 * @return the list size
	 */
	public int getSize();
	
	/**
	 * Add a String to this NBT list
	 * 
	 * @param value the value to add
	 * @return modifiable context. Chain methods
	 */
	public NBTList addString(String value);
	
	/**
	 * Get a String from this NBT list at the given index
	 * 
	 * @param index the index to get
	 * @return the String at the given index
	 */
	public String getString(int index);
	
	/**
	 * Add an int to this NBT list
	 * 
	 * @param value the value to add
	 * @return modifiable context. Chain methods
	 */
	public NBTList addInt(int value);
	
	/**
	 * Get an int from this NBT list at the given index
	 * 
	 * @param index the index to get
	 * @return the int at the given index
	 */
	public int getInt(int index);
	
	/**
	 * Add a double to this NBT list
	 * 
	 * @param value the value to add
	 * @return modifiable context. Chain methods
	 */
	public NBTList addDouble(double value);
	
	/**
	 * Get a double from this NBT list at the given index
	 * 
	 * @param index the index to get
	 * @return the double at the given index
	 */
	public double getDouble(int index);
	
	/**
	 * Add a float to this NBT list
	 * 
	 * @param value the value to add
	 * @return modifiable context. Chain methods
	 */
	public NBTList addFloat(float value);
	
	/**
	 * Get a float from this NBT list at the given index
	 * 
	 * @param index the index to get
	 * @return the float at the given index
	 */
	public float getFloat(int index);
	
	/**
	 * Add an NBTCompound to this NBT list
	 * 
	 * @param value the value to add
	 * @return modifiable context. Chain methods
	 */
	public NBTList addNBTCompound(NBTCompound value);
	
	
	/**
	 * Get an NBTCompound from this NBT list at the given index
	 * 
	 * @param index the index to get
	 * @return the NBTCompound at the given index
	 */
	public NBTCompound getNBTCompound(int index);
	
	/**
	 * Add an NBT value to this NBT list
	 * 
	 * @param value the value to add
	 * @return modifiable context. Chain methods
	 */
	public NBTList addNBTValue(NBTBase value);
	
	
	/**
	 * Get an NBT value from this NBT list at the given index
	 * 
	 * @param index the index to get
	 * @return the NBT value at the given index
	 */
	public NBTBase getNBTValue(int index);
	
}