package me.choco.nbt.types;

import static me.choco.nbt.utils.ReflectionUtils.*;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.inventory.ItemStack;

import com.google.common.base.Preconditions;

import me.choco.nbt.utils.NBTModifiable;

public class NBTItem implements NBTModifiable<ItemStack> {
	
	private final ItemStack item;
	private final Object nmsItem;
	
	public NBTItem(ItemStack item) {
		Preconditions.checkNotNull(item, "Cannot modify the NBT of a null ItemStack");
		
		this.item = item;
		this.nmsItem = getNMSItemStack(item);
	}
	
	public ItemStack getItem() {
		return item;
	}

	@Override
	public boolean isSupported() {
		return this.nmsItem != null;
	}

	@Override
	public ItemStack removeKey(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		try {
			Object nbt = methodGetTag.invoke(nmsItem);
			if (nbt == null) return item;
			
			methodRemove.invoke(nbt, key);
			methodSetTag.invoke(nmsItem, nbt);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		return item;
	}

	@Override
	public boolean hasKey(String key) {
		if (key == null) return false;
		boolean hasTag = false;
		
		try {
			Object nbt = methodGetTag.invoke(nmsItem);
			if (nbt == null) return false;
			
			hasTag = (boolean) methodHasKey.invoke(nbt, key);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		
		return hasTag;
	}

	@Override
	public ItemStack setString(String key, String value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		try {
			Object nbt = methodGetTag.invoke(nmsItem);
			if (nbt == null) nbt = newNBTTagCompound();
			
			methodSetString.invoke(nbt, key, value);
			methodSetTag.invoke(nmsItem, nbt);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		
		return item;
	}

	@Override
	public String getString(String key) {
		if (key == null) return "";
		String result = null;
		
		try {
			Object nmsItem = methodAsNMSCopy.invoke(null, item);
			Object nbt = methodGetTag.invoke(nmsItem);
			if (nbt == null) return "";
			
			result = (String) methodGetString.invoke(nbt, key);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); }
		
		return result;
	}

	@Override
	public ItemStack setInt(String key, int value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return item;
	}

	@Override
	public int getInt(String key, int value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return 0;
	}

	@Override
	public ItemStack setDouble(String key, double value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return item;
	}

	@Override
	public double getDouble(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return 0;
	}

	@Override
	public ItemStack setFloat(String key, float value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return item;
	}

	@Override
	public float getFloat(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return 0;
	}

	@Override
	public ItemStack setShort(String key, short value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return item;
	}

	@Override
	public short getShort(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return 0;
	}

	@Override
	public ItemStack setLong(String key, long value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return item;
	}

	@Override
	public long getLong(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return 0;
	}

	@Override
	public ItemStack setByte(String key, byte value) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return item;
	}

	@Override
	public byte getByte(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
		
		return 0;
	}

}