package me.choco.nbt.nbt.data;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.nbt.NBTList;
import me.choco.nbt.utils.Applier;
import me.choco.nbt.utils.NBTModifiable;

/**
 * Various types of data that can be set or retrieved from NBT
 * 
 * @author Parker Hawke - 2008Choco
 */
public final class NBTDataType<T> {

	private static final Set<NBTDataType<?>> DATA_TYPES = new HashSet<>();
	
	/** A String type. Friendly name: "string" */
	public static final NBTDataType<String> STRING = new NBTDataType<String>((nbt, key, value) -> nbt.setString(key, value), "string");
	
	/** A primitive int type. Friendly names: "integer" and "int" */
	public static final NBTDataType<Integer> INT = new NBTDataType<Integer>((nbt, key, value) -> nbt.setInt(key, value), "integer", "int");
	
	/** A primitive double type. Friendly name: "double" */
	public static final NBTDataType<Double> DOUBLE = new NBTDataType<Double>((nbt, key, value) -> nbt.setDouble(key, value), "double");
	
	/** A primitive float type. Friendly name: "float" */
	public static final NBTDataType<Float> FLOAT = new NBTDataType<Float>((nbt, key, value) -> nbt.setFloat(key, value), "float");
	
	/** A primitive short type. Friendly name: "short" */
	public static final NBTDataType<Short> SHORT = new NBTDataType<Short>((nbt, key, value) -> nbt.setShort(key, value), "short");
	
	/** A primitive long type. Friendly name: "long" */
	public static final NBTDataType<Long> LONG = new NBTDataType<Long>((nbt, key, value) -> nbt.setLong(key, value), "long");
	
	/** A primitive byte type. Friendly name: "byte" */
	public static final NBTDataType<Byte> BYTE = new NBTDataType<Byte>((nbt, key, value) -> nbt.setByte(key, value), "byte");
	
	/** A primitive boolean type. Friendly name: "boolean" and "bool" */
	public static final NBTDataType<Boolean> BOOLEAN = new NBTDataType<Boolean>((nbt, key, value) -> nbt.setBoolean(key, value), "boolean", "bool");
	
	// TODO
	/** An NBTBase type. Represents a JSON Object in the NBT structure */
	public static final NBTDataType<NBTCompound> NBT_COMPOUND = new NBTDataType<NBTCompound>((nbt, key, value) -> nbt.setNBTValue(key, value), "nbtcompound", "compound");

	/** An NBTBase type. Represents a JSON Array in the NBT structure */
	public static final NBTDataType<NBTList> NBT_LIST = new NBTDataType<NBTList>((nbt, key, value) -> nbt.setNBTValue(key, value), "nbtlist", "list");
	
	private final Applier<T> applier;
	private final String[] friendlyNames;
	
	private NBTDataType(Applier<T> applier, String... friendlyNames) {
		this.applier = applier;
		this.friendlyNames = friendlyNames;
		DATA_TYPES.add(this);
	}

	/**
	 * Get the friendly names, or aliases, that refer to this constant
	 * 
	 * @return all friendly names. (Most have only 1)
	 */
	public String[] getFriendlyNames() {
		return friendlyNames;
	}
	
	/**
	 * Apply the NBT value to an NBTModifiable object
	 * 
	 * @param nbtModifiable - The object to modify
	 * @param key - The key to set
	 * @param value - The value of the key
	 */
	public void applyToNBTModifiable(NBTModifiable nbtModifiable, String key, T value) {
		applier.apply(nbtModifiable, key, value);
	}
	
	/**
	 * Get an NBTDataType by its name. Aliases are taken into consideration
	 * 
	 * @param name - The name to search for
	 * @return the data type with the given name. Null if none found
	 */
	public static NBTDataType<?> getByName(String name) {
		for (NBTDataType<?> type : DATA_TYPES) 
			if (ArrayUtils.contains(type.getFriendlyNames(), name)) return type;
		return null;
	}
	
}