package me.choco.nbt.nbt;

import me.choco.nbt.nbt.data.NBTBaseBoolean;
import me.choco.nbt.nbt.data.NBTBaseByte;
import me.choco.nbt.nbt.data.NBTBaseDouble;
import me.choco.nbt.nbt.data.NBTBaseFloat;
import me.choco.nbt.nbt.data.NBTBaseInt;
import me.choco.nbt.nbt.data.NBTBaseLong;
import me.choco.nbt.nbt.data.NBTBaseShort;
import me.choco.nbt.nbt.data.NBTBaseString;
import me.choco.nbt.nbt.data.NBTDataType;
import me.choco.nbt.utils.NBTModifiable;

/**
 * Represents the base of all NBT component objects. Can be modified
 * and placed on an {@link NBTModifiable} context
 * 
 * @author Parker Hawke - 2008Choco
 */
public abstract class NBTBase {
	
	/**
	 * Whether the NBT value has any keys or not
	 * 
	 * @return true if there are no keys present
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Clone the NBTBase into a new object
	 */
	public abstract NBTBase clone();
	
	@Override
	public abstract boolean equals(Object tag);
	
	/**
	 * Create an NBTBase object with a set data type
	 * 
	 * @param type - The type of NBT data to create
	 * @param value - The value to set
	 * 
	 * @return the new NBTBase. Null if none exist
	 */
	public static <T> NBTBase createNBTBase(NBTDataType<T> type, T value) {
		if (type == NBTDataType.STRING) return new NBTBaseString((String) value);
		if (type == NBTDataType.INT) return new NBTBaseInt((int) value);
		if (type == NBTDataType.DOUBLE) return new NBTBaseDouble((double) value);
		if (type == NBTDataType.FLOAT) return new NBTBaseFloat((float) value);
		if (type == NBTDataType.SHORT) return new NBTBaseShort((short) value);
		if (type == NBTDataType.LONG) return new NBTBaseLong((long) value);
		if (type == NBTDataType.BYTE) return new NBTBaseByte((byte) value);
		if (type == NBTDataType.BOOLEAN) return new NBTBaseBoolean((boolean) value);
		if (type == NBTDataType.NBT_COMPOUND) return new NBTCompound();
		if (type == NBTDataType.NBT_LIST) return new NBTList();
		
		return null;
	}
	
}