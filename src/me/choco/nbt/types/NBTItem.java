package me.choco.nbt.types;

import static me.choco.nbt.utils.ReflectionUtils.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.Preconditions;

import org.bukkit.inventory.ItemStack;

import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.utils.NBTModifiable;

/**
 * An ItemStack object with modifiable NBT data
 * 
 * @author Parker Hawke - 2008Choco
 */
public class NBTItem implements NBTModifiable {
	
	private final ItemStack item;
	private final Object nmsItem;
	
	/**
	 * Create a new instance of an ItemStack with modifiable NBT data
	 * 
	 * @param item - The Bukkit ItemStack
	 */
	public NBTItem(ItemStack item) {
		Preconditions.checkNotNull(item, "Cannot modify the NBT of a null ItemStack");
		
		this.item = item;
		this.nmsItem = getNMSItemStack(item);
	}
	
	/**
	 * Get the resulting ItemStack with the modified NBT data. If unsuccessfully,
	 * the unmodified ItemStack will be returned
	 * 
	 * @return the ItemStack with NBT data
	 */
	public ItemStack getModifiedItemStack() {
		ItemStack modifiedItem = getBukkitItemStack(nmsItem);
		return modifiedItem != null ? modifiedItem : item;
	}
	
	// TODO Apply any NBTBase information to the NBT data

	@Override
	public boolean isSupported() {
		return this.nmsItem != null;
	}

	@Override
	public NBTItem removeKey(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		try {
			Object nbt = methodItemStackGetTag.invoke(nmsItem);
			if (nbt == null) return this;
			
			methodRemove.invoke(nbt, key);
			methodItemStackSetTag.invoke(nmsItem, nbt);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		return this;
	}

	@Override
	public boolean hasKey(String key) {
		if (key == null) return false;
		boolean hasTag = false;
		
		try {
			Object nbt = methodItemStackGetTag.invoke(nmsItem);
			if (nbt == null) return false;
			
			hasTag = (boolean) methodHasKey.invoke(nbt, key);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		
		return hasTag;
	}

	@Override
	public NBTItem setString(String key, String value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetString, key, value);
		return this;
	}

	@Override
	public String getString(String key) {
		if (key == null) return "";
		return this.getNBTValue(methodGetString, key, String.class, "");
	}

	@Override
	public NBTItem setInt(String key, int value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetInt, key, value);
		return this;
	}

	@Override
	public int getInt(String key) {
		if (key == null) return -1;
		return this.getNBTValue(methodGetInt, key, Integer.class, -1);
	}

	@Override
	public NBTItem setDouble(String key, double value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetDouble, key, value);
		return this;
	}

	@Override
	public double getDouble(String key) {
		if (key == null) return -1;
		return this.getNBTValue(methodGetDouble, key, Double.class, -1d);
	}

	@Override
	public NBTItem setFloat(String key, float value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetFloat, key, value);
		return this;
	}

	@Override
	public float getFloat(String key) {
		if (key == null) return -1;
		return this.getNBTValue(methodGetFloat, key, Float.class, -1f);
	}

	@Override
	public NBTItem setShort(String key, short value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetShort, key, value);
		return this;
	}

	@Override
	public short getShort(String key) {
		if (key == null) return -1;
		return this.getNBTValue(methodGetShort, key, Short.class, (short) -1);
	}

	@Override
	public NBTItem setLong(String key, long value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetLong, key, value);
		return this;
	}

	@Override
	public long getLong(String key) {
		if (key == null) return -1;
		return this.getNBTValue(methodGetLong, key, Long.class, -1l);
	}

	@Override
	public NBTItem setByte(String key, byte value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetByte, key, value);
		return this;
	}

	@Override
	public byte getByte(String key) {
		if (key == null) return -1;
		return this.getNBTValue(methodGetByte, key, Byte.class, (byte) -1);
	}

	@Override
	public NBTItem setBoolean(String key, boolean value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		this.setNBTValue(methodSetBoolean, key, value);
		return this;
	}

	@Override
	public boolean getBoolean(String key) {
		if (key == null) return false;
		return this.getNBTValue(methodGetBoolean, key, Boolean.class, false);
	}

	@Override
	public NBTModifiable setNBTValue(String key, NBTBase nbtTag) {
		return null;
	}

	@Override
	public NBTBase getNBTValue(String key) {
		return null;
	}
	
	/**
	 * Set a value in the item's NBT structure
	 * 
	 * @param method - The reflected method to call. Should be a set method
	 * @param key - The key to set
	 * @param value - The value to set
	 */
	private <T> void setNBTValue(Method method, String key, T value) {
		try {
			Object nbt = methodItemStackGetTag.invoke(nmsItem);
			if (nbt == null) nbt = newNBTTagCompound();
			
			method.invoke(nbt, key, value);
			methodItemStackSetTag.invoke(nmsItem, nbt);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
	}
	
	/**
	 * Get a value in the item's NBT structure
	 * 
	 * @param method - The reflected method to call. Should be a get method
	 * @param key - The key to get
	 * @param returnType - The type of object that will be returned
	 * @param defaultValue - The default value to return if no value was present
	 * @return the value of the key, or the default value if not found
	 */
	private <T> T getNBTValue(Method method, String key, Class<T> returnType, T defaultValue) {
		try {
			Object nbt = methodItemStackGetTag.invoke(nmsItem);
			if (nbt == null) return defaultValue;
			
			return returnType.cast(method.invoke(nbt, key));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		return defaultValue;
	}
}