package me.choco.nbt.impl.v1_12_R1;

import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.nbt.NBTList;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagDouble;
import net.minecraft.server.v1_12_R1.NBTTagFloat;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class NBTList1_12_R1 extends NBTBase1_12_R1 implements NBTList {
	
	public NBTList1_12_R1(NBTTagList list) {
		super(list);
	}
	
	public NBTList1_12_R1() {
		super(new NBTTagList());
	}
	
	@Override
	public int getSize() {
		return ((NBTTagList) base).size();
	}
	
	@Override
	public NBTList addString(String value) {
		((NBTTagList) base).add(new NBTTagString(value));
		return this;
	}
	
	@Override
	public String getString(int index) {
		return ((NBTTagList) base).getString(index);
	}
	
	@Override
	public NBTList addInt(int value) {
		((NBTTagList) base).add(new NBTTagInt(value));
		return this;
	}
	
	@Override
	public int getInt(int index) {
		return ((NBTTagList) base).c(index);
	}
	
	@Override
	public NBTList addDouble(double value) {
		((NBTTagList) base).add(new NBTTagDouble(value));
		return this;
	}
	
	@Override
	public double getDouble(int index) {
		return ((NBTTagList) base).f(index);
	}
	
	@Override
	public NBTList addFloat(float value) {
		((NBTTagList) base).add(new NBTTagFloat(value));
		return this;
	}
	
	@Override
	public float getFloat(int index) {
		return ((NBTTagList) base).g(index);
	}
	
	@Override
	public NBTList addNBTCompound(NBTCompound value) {
		((NBTTagList) base).add((NBTTagCompound) value.toNMS());
		return this;
	}
	
	@Override
	public NBTCompound getNBTCompound(int index) {
		return new NBTCompound1_12_R1(((NBTTagList) base).get(index));
	}
	
	@Override
	public NBTList addNBTValue(NBTBase value) {
		((NBTTagList) base).add((net.minecraft.server.v1_12_R1.NBTBase) value.toNMS());
		return null;
	}
	
	@Override
	public NBTBase getNBTValue(int index) {
		return fromNMSBase(((NBTTagList) base).i(index));
	}
	
	@Override
	public NBTBase clone() {
		return new NBTList1_12_R1(((NBTTagList) base).d());
	}
	
}