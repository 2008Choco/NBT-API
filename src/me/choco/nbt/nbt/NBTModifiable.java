package me.choco.nbt.nbt;

/**
 * Represents an object that supports the modification of its NBT tags
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface NBTModifiable {
	
	/**
	 * Whether the implementation is supported or not. If this
	 * value returns false, methods may be unusable or unstable
	 * 
	 * @return true if supported
	 */
	public boolean isSupported();
	
	/**
	 * Remove a key-value pair from the NBT structure
	 * 
	 * @param key the key to remove
	 * @return modifiable context. Chain methods
	 */
	public NBTModifiable removeKey(String key);
	
	/**
	 * Check whether a key-value pair is present in the NBT structure
	 * 
	 * @param key the key to check
	 * @return true if it is present
	 */
	public boolean hasKey(String key);
	
	/**
	 * Set a key to a String value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setString(String key, String value);
	
	/**
	 * Get a String value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public String getString(String key);
	
	/**
	 * Set a key to a integer value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setInt(String key, int value);
	
	/**
	 * Get an integer value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public int getInt(String key);
	
	/**
	 * Set a key to a double value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setDouble(String key, double value);
	
	/**
	 * Get a double value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public double getDouble(String key);
	
	/**
	 * Set a key to a float value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setFloat(String key, float value);
	
	/**
	 * Get a float value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public float getFloat(String key);
	
	/**
	 * Set a key to a short value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setShort(String key, short value);
	
	/**
	 * Get a short value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public short getShort(String key);
	
	/**
	 * Set a key to a long value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setLong(String key, long value);
	
	/**
	 * Get a long value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public long getLong(String key);
	
	/**
	 * Set a key to a byte value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setByte(String key, byte value);
	
	/**
	 * Get a byte value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public byte getByte(String key);
	
	/**
	 * Set a key to a boolean value. A new key will be created if it 
	 * was not present on the NBT structure. Alternatively, the value 
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param value the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
    public NBTModifiable setBoolean(String key, boolean value);
	
	/**
	 * Get a boolean value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
    public boolean getBoolean(String key);
	
	/**
	 * Set a key to an NBT component. A new key will be created if it
	 * was not present on the NBT structure. Alternatively, the value
	 * of the existing key will be overwritten
	 * 
	 * @param key the key to set
	 * @param nbtTag the value of the key
	 * 
	 * @return modifiable context. Chain methods
	 */
	public NBTModifiable setNBTValue(String key, NBTBase nbtTag);
	
	/**
	 * Get a NBT component value from a key in the NBT structure
	 * 
	 * @param key the key to get
	 * @return the value of the key. Default value if not present
	 */
	public NBTBase getNBTValue(String key);
	
	/**
	 * Set the tag associated with this NBTModifiable instance
	 * 
	 * @param compound the compound to get
	 * @return modifiable context. Chain methods
	 */
	public NBTModifiable setTag(NBTCompound compound);
	
	/**
	 * Get a copy of the root tag compound for this NBTModifiable instance. Any
	 * changes made to the NBTCompound returned from this method will not affect
	 * the underlying NBTModifiable instance
	 * 
	 * @return this object's root compound tag
	 */
	public NBTCompound getTag();
	
}