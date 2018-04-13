package me.choco.nbt.nbt.data;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.nbt.NBTList;
import me.choco.nbt.nbt.NBTModifiable;
import me.choco.nbt.utils.Applier;

/**
 * Various types of data that can be set or retrieved from NBT
 * 
 * @param <T> the type of data for this NBT data type
 * 
 * @author Parker Hawke - 2008Choco
 */
public final class NBTDataType<T> {
	
	/**
	 * A String type. Friendly name: "string"
	 */
	public static final NBTDataType<String> STRING = new NBTDataType<>(NBTModifiable::setString, "string");
	
	/**
	 * A primitive int type. Friendly names: "integer" and "int"
	 */
	public static final NBTDataType<Integer> INT = new NBTDataType<>(NBTModifiable::setInt, "integer", "int");
	
	/**
	 * A primitive double type. Friendly name: "double"
	 */
	public static final NBTDataType<Double> DOUBLE = new NBTDataType<>(NBTModifiable::setDouble, "double");
	
	/**
	 * A primitive float type. Friendly name: "float"
	 */
	public static final NBTDataType<Float> FLOAT = new NBTDataType<>(NBTModifiable::setFloat, "float");
	
	/**
	 * A primitive short type. Friendly name: "short"
	 */
	public static final NBTDataType<Short> SHORT = new NBTDataType<>(NBTModifiable::setShort, "short");
	
	/**
	 * A primitive long type. Friendly name: "long"
	 */
	public static final NBTDataType<Long> LONG = new NBTDataType<>(NBTModifiable::setLong, "long");
	
	/**
	 * A primitive byte type. Friendly name: "byte"
	 */
	public static final NBTDataType<Byte> BYTE = new NBTDataType<>(NBTModifiable::setByte, "byte");
	
	/**
	 * A int[] type. Friendly names: "integer_array" and "int_array"
	 */
	public static final NBTDataType<int[]> INT_ARRAY = new NBTDataType<>(NBTModifiable::setIntArray, "integer_array", "int_array");
	
	/**
	 * A byte[] type. Friendly name: "byte_array"
	 */
	public static final NBTDataType<byte[]> BYTE_ARRAY = new NBTDataType<>(NBTModifiable::setByteArray, "byte_array");
	
	/**
	 * An NBTBase type. Represents a JSON Object in the NBT structure
	 */
	public static final NBTDataType<NBTCompound> NBT_COMPOUND = new NBTDataType<>(NBTModifiable::setNBTValue, "nbtcompound", "compound");
	
	/**
	 * An NBTBase type. Represents a JSON Array in the NBT structure
	 */
	public static final NBTDataType<NBTList> NBT_LIST = new NBTDataType<>(NBTModifiable::setNBTValue, "nbtlist", "list");
	
	
	private static final Set<NBTDataType<?>> DATA_TYPES = new HashSet<>();
	
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
	 * @param nbtModifiable the object to modify
	 * @param key the key to set
	 * @param value the value of the key
	 */
	public void applyToNBTModifiable(NBTModifiable nbtModifiable, String key, T value) {
		this.applier.apply(nbtModifiable, key, value);
	}
	
	/**
	 * Apply the NBT value to an NBTModifiable object in the case that the NBTDataType was
	 * received from {@link #getByName(String)} and Java's type erasure did its magic. In
	 * such a situation, the generic type is erased and cannot be infered, therefore a
	 * generic Object must be used instead. This method explicitly casts the provided "value"
	 * parameter to type T and thus should be avoided unless absolutely necessary. 
	 * <p>
	 * In a case where NBTDataType is explicitly referenced,
	 * {@link #applyToNBTModifiable(NBTModifiable, String, Object)} should be used instead
	 * 
	 * @param nbtModifiable the object to modify
	 * @param key the key to set
	 * @param value the value of the key
	 */
	@SuppressWarnings("unchecked")
	public void applyToNBTModifiableGeneric(NBTModifiable nbtModifiable, String key, Object value) {
		this.applier.apply(nbtModifiable, key, (T) value);
	}
	
	/**
	 * Get an NBTDataType by its name. Aliases are taken into consideration
	 * 
	 * @param name the name to search for
	 * @return the data type with the given name. Null if none found
	 */
	public static NBTDataType<?> getByName(String name) {
		for (NBTDataType<?> type : DATA_TYPES) 
			if (ArrayUtils.contains(type.getFriendlyNames(), name)) return type;
		return null;
	}
	
}