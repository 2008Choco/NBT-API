package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBasePrimitive;

import net.minecraft.server.v1_12_R1.NBTTagFloat;

public class NBTBaseFloat1_12_R1 extends NBTBase1_12_R1 implements NBTBasePrimitive {
	
	public NBTBaseFloat1_12_R1(NBTTagFloat base) {
		super(base);
	}
	
	public NBTBaseFloat1_12_R1(float value) {
		super(new NBTTagFloat(value));
	}

	@Override
	public long getAsLong() {
		return ((NBTTagFloat) base).d();
	}
	
	@Override
	public int getAsInt() {
		return ((NBTTagFloat) base).e();
	}
	
	@Override
	public short getAsShort() {
		return ((NBTTagFloat) base).f();
	}
	
	@Override
	public byte getAsByte() {
		return ((NBTTagFloat) base).g();
	}
	
	@Override
	public double getAsDouble() {
		return ((NBTTagFloat) base).asDouble();
	}
	
	@Override
	public float getAsFloat() {
		return ((NBTTagFloat) base).i();
	}
	
	@Override
	public String getAsString() {
		return String.valueOf(((NBTTagFloat) base).i());
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseFloat1_12_R1(((NBTTagFloat) base).c());
	}
	
}