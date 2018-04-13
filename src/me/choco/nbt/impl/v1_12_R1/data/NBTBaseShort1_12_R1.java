package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBasePrimitive;

import net.minecraft.server.v1_12_R1.NBTTagShort;

public class NBTBaseShort1_12_R1 extends NBTBase1_12_R1 implements NBTBasePrimitive {
	
	public NBTBaseShort1_12_R1(NBTTagShort base) {
		super(base);
	}
	
	public NBTBaseShort1_12_R1(short value) {
		super(new NBTTagShort(value));
	}

	@Override
	public long getAsLong() {
		return ((NBTTagShort) base).d();
	}
	
	@Override
	public int getAsInt() {
		return ((NBTTagShort) base).e();
	}
	
	@Override
	public short getAsShort() {
		return ((NBTTagShort) base).f();
	}
	
	@Override
	public byte getAsByte() {
		return ((NBTTagShort) base).g();
	}
	
	@Override
	public double getAsDouble() {
		return ((NBTTagShort) base).asDouble();
	}
	
	@Override
	public float getAsFloat() {
		return ((NBTTagShort) base).i();
	}
	
	@Override
	public String getAsString() {
		return String.valueOf(((NBTTagShort) base).f());
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseShort1_12_R1(((NBTTagShort) base).c());
	}
	
}