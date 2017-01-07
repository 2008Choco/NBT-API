package me.choco.nbt.utils;

public interface NBTModifiable {
	
	/* Possible NBT data types:
	 *   - String
	 *   - Int
	 *   - Double
	 *   - Float
	 *   - Short
	 *   - Long
	 *   - Byte
	 *   - Boolean
	 *   - NBTBase TODO
	 */
	
	public boolean isSupported();
	
	public NBTModifiable removeKey(String key);
	
	public boolean hasKey(String key);
	
	public NBTModifiable setString(String key, String value);
	
	public String getString(String key);
	
	public NBTModifiable setInt(String key, int value);
	
	public int getInt(String key);
	
	public NBTModifiable setDouble(String key, double value);
	
	public double getDouble(String key);
	
	public NBTModifiable setFloat(String key, float value);
	
	public float getFloat(String key);
	
	public NBTModifiable setShort(String key, short value);
	
	public short getShort(String key);
	
	public NBTModifiable setLong(String key, long value);
	
	public long getLong(String key);
	
	public NBTModifiable setByte(String key, byte value);
	
	public byte getByte(String key);
	
	public NBTModifiable setBoolean(String key, boolean value);
	
	public boolean getBoolean(String key);
	
}