package me.choco.nbt.impl.v1_12_R1.modifiable;

import me.choco.nbt.impl.v1_12_R1.NBTCompound1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.types.NBTEntity;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

public class NBTEntity1_12_R1<T extends Entity> implements NBTEntity<T> {
	
	private final T entity;
	private NBTCompound root;
	
	public NBTEntity1_12_R1(T entity) {
		this.entity = entity;
		this.root = new NBTCompound1_12_R1(((CraftEntity) entity).getHandle().save(new NBTTagCompound()));
	}
	
	@Override
	public boolean isSupported() {
		return entity != null && !entity.isDead() && entity.isValid() && root != null;
	}
	
	@Override
	public T getEntity() {
		return entity;
	}
	
	@Override
	public void saveNBT() {
		((CraftEntity) entity).getHandle().f((NBTTagCompound) root.toNMS());
	}
	
	@Override
	public NBTEntity<T> removeKey(String key) {
		this.root.removeKey(key);
		return this;
	}
	
	@Override
	public boolean hasKey(String key) {
		return root.hasKey(key);
	}
	
	@Override
	public NBTEntity<T> setString(String key, String value) {
		this.root.setString(key, value);
		return this;
	}
	
	@Override
	public String getString(String key) {
		return root.getString(key);
	}
	
	@Override
	public NBTEntity<T> setInt(String key, int value) {
		this.root.setInt(key, value);
		return this;
	}
	
	@Override
	public int getInt(String key) {
		return root.getInt(key);
	}
	
	@Override
	public NBTEntity<T> setDouble(String key, double value) {
		this.root.setDouble(key, value);
		return this;
	}
	
	@Override
	public double getDouble(String key) {
		return root.getDouble(key);
	}
	
	@Override
	public NBTEntity<T> setFloat(String key, float value) {
		this.root.setFloat(key, value);
		return this;
	}
	
	@Override
	public float getFloat(String key) {
		return root.getFloat(key);
	}
	
	@Override
	public NBTEntity<T> setShort(String key, short value) {
		this.root.setShort(key, value);
		return this;
	}
	
	@Override
	public short getShort(String key) {
		return root.getShort(key);
	}
	
	@Override
	public NBTEntity<T> setLong(String key, long value) {
		this.root.setLong(key, value);
		return this;
	}
	
	@Override
	public long getLong(String key) {
		return root.getLong(key);
	}
	
	@Override
	public NBTEntity<T> setByte(String key, byte value) {
		this.root.setByte(key, value);
		return this;
	}
	
	@Override
	public byte getByte(String key) {
		return root.getByte(key);
	}
	
	@Override
	public NBTEntity<T> setBoolean(String key, boolean value) {
		this.root.setBoolean(key, value);
		return this;
	}
	
	@Override
	public boolean getBoolean(String key) {
		return root.getBoolean(key);
	}
	
	@Override
	public NBTEntity<T> setIntArray(String key, int[] value) {
		this.root.setIntArray(key, value);
		return this;
	}
	
	@Override
	public int[] getIntArray(String key) {
		return root.getIntArray(key);
	}
	
	@Override
	public NBTEntity<T> setByteArray(String key, byte[] value) {
		this.root.setByteArray(key, value);
		return this;
	}
	
	@Override
	public byte[] getByteArray(String key) {
		return root.getByteArray(key);
	}
	
	@Override
	public NBTEntity<T> setNBTValue(String key, NBTBase nbtTag) {
		this.root.setNBTValue(key, nbtTag);
		return this;
	}
	
	@Override
	public NBTBase getNBTValue(String key) {
		return root.getNBTValue(key);
	}
	
	@Override
	public NBTEntity<T> setTag(NBTCompound compound) {
		this.root = (compound != null) ? compound : new NBTCompound1_12_R1();
		return this;
	}
	
	@Override
	public NBTCompound getTag() {
		return (NBTCompound) root.clone();
	}
	
}