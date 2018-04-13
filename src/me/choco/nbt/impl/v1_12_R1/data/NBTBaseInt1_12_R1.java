package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBasePrimitive;

import net.minecraft.server.v1_12_R1.NBTTagInt;

public class NBTBaseInt1_12_R1 extends NBTBase1_12_R1 implements NBTBasePrimitive {
	
	public NBTBaseInt1_12_R1(NBTTagInt base) {
		super(base);
	}
	
	public NBTBaseInt1_12_R1(int value) {
		super(new NBTTagInt(value));
	}

	@Override
	public long getAsLong() {
		return ((NBTTagInt) base).d();
	}
	
	@Override
	public int getAsInt() {
		return ((NBTTagInt) base).e();
	}
	
	@Override
	public short getAsShort() {
		return ((NBTTagInt) base).f();
	}
	
	@Override
	public byte getAsByte() {
		return ((NBTTagInt) base).g();
	}
	
	@Override
	public double getAsDouble() {
		return ((NBTTagInt) base).asDouble();
	}
	
	@Override
	public float getAsFloat() {
		return ((NBTTagInt) base).i();
	}
	
	@Override
	public String getAsString() {
		return String.valueOf(((NBTTagInt) base).e());
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseInt1_12_R1(((NBTTagInt) base).c());
	}
	
}