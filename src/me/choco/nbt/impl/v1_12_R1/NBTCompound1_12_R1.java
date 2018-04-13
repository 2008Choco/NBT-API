package me.choco.nbt.impl.v1_12_R1;

import com.google.common.base.Preconditions;

import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class NBTCompound1_12_R1 extends NBTBase1_12_R1 implements NBTCompound {
	
	public NBTCompound1_12_R1(NBTTagCompound compound) {
		super(compound);
	}
	
	public NBTCompound1_12_R1() {
		super(new NBTTagCompound());
	}
	
	@Override
	public NBTCompound removeKey(String key) {
		((NBTTagCompound) base).remove(key);
		return this;
	}
	
	@Override
	public boolean hasKey(String key) {
		return ((NBTTagCompound) base).hasKey(key);
	}
	
	@Override
	public NBTCompound setString(String key, String value) {
		((NBTTagCompound) base).setString(key, value);
		return this;
	}
	
	@Override
	public String getString(String key) {
		return ((NBTTagCompound) base).getString(key);
	}
	
	@Override
	public NBTCompound setInt(String key, int value) {
		((NBTTagCompound) base).setInt(key, value);
		return this;
	}
	
	@Override
	public int getInt(String key) {
		return ((NBTTagCompound) base).getInt(key);
	}
	
	@Override
	public NBTCompound setDouble(String key, double value) {
		((NBTTagCompound) base).setDouble(key, value);
		return this;
	}
	
	@Override
	public double getDouble(String key) {
		return ((NBTTagCompound) base).getDouble(key);
	}
	
	@Override
	public NBTCompound setFloat(String key, float value) {
		((NBTTagCompound) base).setFloat(key, value);
		return this;
	}
	
	@Override
	public float getFloat(String key) {
		return ((NBTTagCompound) base).getFloat(key);
	}
	
	@Override
	public NBTCompound setShort(String key, short value) {
		((NBTTagCompound) base).setShort(key, value);
		return this;
	}
	
	@Override
	public short getShort(String key) {
		return ((NBTTagCompound) base).getShort(key);
	}
	
	@Override
	public NBTCompound setLong(String key, long value) {
		((NBTTagCompound) base).setLong(key, value);
		return this;
	}
	
	@Override
	public long getLong(String key) {
		return ((NBTTagCompound) base).getLong(key);
	}
	
	@Override
	public NBTCompound setByte(String key, byte value) {
		((NBTTagCompound) base).setByte(key, value);
		return this;
	}
	
	@Override
	public byte getByte(String key) {
		return ((NBTTagCompound) base).getByte(key);
	}
	
	@Override
	public NBTCompound setBoolean(String key, boolean value) {
		((NBTTagCompound) base).setBoolean(key, value);
		return this;
	}
	
	@Override
	public boolean getBoolean(String key) {
		return ((NBTTagCompound) base).getBoolean(key);
	}
	
	@Override
	public NBTCompound setNBTValue(String key, NBTBase value) {
		Preconditions.checkArgument(value.toNMS() instanceof net.minecraft.server.v1_12_R1.NBTBase, "Wrong implementation type set (1.12 R1 expected)");
		
		((NBTTagCompound) base).set(key, (net.minecraft.server.v1_12_R1.NBTBase) value.toNMS());
		return this;
	}
	
	@Override
	public NBTBase getNBTValue(String key) {
		return fromNMSBase(((NBTTagCompound) base).get(key));
	}
	
	@Override
	public NBTBase clone() {
		return new NBTCompound1_12_R1(((NBTTagCompound) base).g());
	}
	
}