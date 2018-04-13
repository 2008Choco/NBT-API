package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBasePrimitive;

import net.minecraft.server.v1_12_R1.NBTTagLong;

public class NBTBaseLong1_12_R1 extends NBTBase1_12_R1 implements NBTBasePrimitive {
	
	public NBTBaseLong1_12_R1(NBTTagLong base) {
		super(base);
	}
	
	public NBTBaseLong1_12_R1(long value) {
		super(new NBTTagLong(value));
	}

	@Override
	public long getAsLong() {
		return ((NBTTagLong) base).d();
	}
	
	@Override
	public int getAsInt() {
		return ((NBTTagLong) base).e();
	}
	
	@Override
	public short getAsShort() {
		return ((NBTTagLong) base).f();
	}
	
	@Override
	public byte getAsByte() {
		return ((NBTTagLong) base).g();
	}
	
	@Override
	public double getAsDouble() {
		return ((NBTTagLong) base).asDouble();
	}
	
	@Override
	public float getAsFloat() {
		return ((NBTTagLong) base).i();
	}
	
	@Override
	public String getAsString() {
		return String.valueOf(((NBTTagLong) base).d());
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseLong1_12_R1(((NBTTagLong) base).c());
	}
	
}