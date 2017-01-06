package me.choco.nbt.types;

import org.bukkit.inventory.ItemStack;

import me.choco.nbt.utils.NBTModifiable;

public class NBTItem implements NBTModifiable<ItemStack> {
	
	private final ItemStack item;
	
	public NBTItem(ItemStack item) {
		this.item = item;
	}
	
	public ItemStack getItem() {
		return item;
	}

	@Override
	public ItemStack removeKey(String key) {
		return item;
	}

	@Override
	public boolean hasKey(String key) {
		return false;
	}

	@Override
	public ItemStack setString(String key, String value) {
		return item;
	}

	@Override
	public String getString(String key) {
		return null;
	}

	@Override
	public ItemStack setInt(String key, int value) {
		return item;
	}

	@Override
	public int getInt(String key, int value) {
		return 0;
	}

	@Override
	public ItemStack setDouble(String key, double value) {
		return item;
	}

	@Override
	public double getDouble(String key) {
		return 0;
	}

	@Override
	public ItemStack setFloat(String key, float value) {
		return item;
	}

	@Override
	public float getFloat(String key) {
		return 0;
	}

	@Override
	public ItemStack setShort(String key, short value) {
		return item;
	}

	@Override
	public short getShort(String key) {
		return 0;
	}

	@Override
	public ItemStack setLong(String key, long value) {
		return item;
	}

	@Override
	public long getLong(String key) {
		return 0;
	}

	@Override
	public ItemStack setByte(String key, byte value) {
		return item;
	}

	@Override
	public byte getByte(String key) {
		return 0;
	}

}