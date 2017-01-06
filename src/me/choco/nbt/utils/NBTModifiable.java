package me.choco.nbt.utils;

public interface NBTModifiable<T> {
	
	/* Possible NBT data types:
	 *   - String
	 *   - Int
	 *   - Double
	 *   - Float
	 *   - Short
	 *   - Long
	 *   - Byte
	 *   - NBTBase TODO
	 */
	
	public T removeKey(String key);
	
	public boolean hasKey(String key);
	
	public T setString(String key, String value);
	
	public String getString(String key);
	
	public T setInt(String key, int value);
	
	public int getInt(String key, int value);
	
	public T setDouble(String key, double value);
	
	public double getDouble(String key);
	
	public T setFloat(String key, float value);
	
	public float getFloat(String key);
	
	public T setShort(String key, short value);
	
	public short getShort(String key);
	
	public T setLong(String key, long value);
	
	public long getLong(String key);
	
	public T setByte(String key, byte value);
	
	public byte getByte(String key);
	
}