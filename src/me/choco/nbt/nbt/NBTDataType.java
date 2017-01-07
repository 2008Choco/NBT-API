package me.choco.nbt.nbt;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.ArrayUtils;

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
	public static final NBTDataType<String> STRING = new NBTDataType<String>((nbt, key, value) -> nbt.setString(key, value.toString()), "string");
	
	/** A primitive int type. Friendly names: "integer" and "int" */
	public static final NBTDataType<Integer> INT = new NBTDataType<Integer>((nbt, key, value) -> nbt.setInt(key, NumberUtils.toInt(value)), "integer", "int");
	
	/** A primitive double type. Friendly name: "double" */
	public static final NBTDataType<Double> DOUBLE = new NBTDataType<Double>((nbt, key, value) -> nbt.setDouble(key, NumberUtils.toDouble(value)), "double");
	
	/** A primitive float type. Friendly name: "float" */
	public static final NBTDataType<Float> FLOAT = new NBTDataType<Float>((nbt, key, value) -> nbt.setFloat(key, NumberUtils.toFloat(value)), "float");
	
	/** A primitive short type. Friendly name: "short" */
	public static final NBTDataType<Short> SHORT = new NBTDataType<Short>((nbt, key, value) -> nbt.setShort(key, NumberUtils.toShort(value)), "short");
	
	/** A primitive long type. Friendly name: "long" */
	public static final NBTDataType<Long> LONG = new NBTDataType<Long>((nbt, key, value) -> nbt.setLong(key, NumberUtils.toLong(value)), "long");
	
	/** A primitive byte type. Friendly name: "byte" */
	public static final NBTDataType<Byte> BYTE = new NBTDataType<Byte>((nbt, key, value) -> nbt.setByte(key, NumberUtils.toByte(value)), "byte");
	
	/** A primitive boolean type. Friendly name: "boolean" */
	public static final NBTDataType<Boolean> BOOLEAN = new NBTDataType<Boolean>((nbt, key, value) -> nbt.setBoolean(key, Boolean.valueOf(value)), "boolean", "bool");
	
//	/** An NBTBase type. Represents a JSON Object in the NBT structure */
//	public static final NBTDataType<NBTCompound> NBTCOMPOUND = new NBTDataType<NBTCompound>("nbtcompound", "compound");

//	/** An NBTBase type. Represents a JSON Array in the NBT structure */
//	public static final NBTDataType<NBTList> NBTLIST = new NBTDataType<NBTList>("nbtcompound", "compound");
	
	private Applier<T> applier;
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
	
	// TODO (See NBTModifiable interface)
	public void applyToNBTModifiable(NBTModifiable nbtModifiable, String key, String value) {
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