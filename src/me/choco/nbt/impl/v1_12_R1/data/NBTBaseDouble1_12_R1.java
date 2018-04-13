package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBasePrimitive;

import net.minecraft.server.v1_12_R1.NBTTagDouble;

public class NBTBaseDouble1_12_R1 extends NBTBase1_12_R1 implements NBTBasePrimitive {
	
	public NBTBaseDouble1_12_R1(NBTTagDouble base) {
		super(base);
	}
	
	public NBTBaseDouble1_12_R1(double value) {
		super(new NBTTagDouble(value));
	}

	@Override
	public long getAsLong() {
		return ((NBTTagDouble) base).d();
	}
	
	@Override
	public int getAsInt() {
		return ((NBTTagDouble) base).e();
	}
	
	@Override
	public short getAsShort() {
		return ((NBTTagDouble) base).f();
	}
	
	@Override
	public byte getAsByte() {
		return ((NBTTagDouble) base).g();
	}
	
	@Override
	public double getAsDouble() {
		return ((NBTTagDouble) base).asDouble();
	}
	
	@Override
	public float getAsFloat() {
		return ((NBTTagDouble) base).i();
	}
	
	@Override
	public String getAsString() {
		return String.valueOf(((NBTTagDouble) base).asDouble());
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseDouble1_12_R1(((NBTTagDouble) base).c());
	}
	
}