package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

/**
 * Represents an abstractified net.minecraft.server.NBTTag{@literal<Primitive>} object.
 * This object acts as a compound with a single primitive value associated with it.
 * This base primitive encompases all primitive NBTTag objects in the net.minecraft.server
 * package, including the following:
 * 
 * <ul>
 * <li><b>byte</b> (<i>net.minecraft.server.NBTTagByte</i>)</li>
 * <li><b>double</b> (<i>net.minecraft.server.NBTTagDouble</i>)</li>
 * <li><b>float</b> (<i>net.minecraft.server.NBTTagFloat</i>)</li>
 * <li><b>int</b> (<i>net.minecraft.server.NBTTagInt</i>)</li>
 * <li><b>long</b> (<i>net.minecraft.server.NBTTagLong</i>)</li>
 * <li><b>short</b> (<i>net.minecraft.server.NBTTagShort</i>)</li>
 * </ul>
 * 
 * For an abstract implementation of <i>net.minecraft.server.NBTTagString</i>, see the
 * non-primitive {@link NBTBaseString}
 * 
 * @author Parker Hawke - 2008Choco
 * 
 * @see NBTBaseString
 */
public interface NBTBasePrimitive extends NBTBase {
	
	/**
	 * Get the value of this NBT primitive as a long
	 * 
	 * @return the value as a long
	 */
	public long getAsLong();
	
	/**
	 * Get the value of this NBT primitive as a int
	 * 
	 * @return the value as a int
	 */
	public int getAsInt();
	
	/**
	 * Get the value of this NBT primitive as a short
	 * 
	 * @return the value as a short
	 */
	public short getAsShort();
	
	/**
	 * Get the value of this NBT primitive as a byte
	 * 
	 * @return the value as a byte
	 */
	public byte getAsByte();
	
	/**
	 * Get the value of this NBT primitive as a double
	 * 
	 * @return the value as a double
	 */
	public double getAsDouble();
	
	/**
	 * Get the value of this NBT primitive as a float
	 * 
	 * @return the value as a float
	 */
	public float getAsFloat();
	
	/**
	 * Get the value of this NBT primitive as a String
	 * 
	 * @return the value as a String
	 * @see NBTBaseString
	 */
	public String getAsString();
	
}