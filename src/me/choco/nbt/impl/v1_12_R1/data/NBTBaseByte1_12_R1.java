package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBasePrimitive;

import net.minecraft.server.v1_12_R1.NBTTagByte;

public class NBTBaseByte1_12_R1 extends NBTBase1_12_R1 implements NBTBasePrimitive {
	
	public NBTBaseByte1_12_R1(NBTTagByte tag) {
		super(tag);
	}
	
	public NBTBaseByte1_12_R1(byte value) {
		super(new NBTTagByte(value));
	}
	
	@Override
	public long getAsLong() {
		return ((NBTTagByte) base).d();
	}
	
	@Override
	public int getAsInt() {
		return ((NBTTagByte) base).e();
	}
	
	@Override
	public short getAsShort() {
		return ((NBTTagByte) base).f();
	}
	
	@Override
	public byte getAsByte() {
		return ((NBTTagByte) base).g();
	}
	
	@Override
	public double getAsDouble() {
		return ((NBTTagByte) base).asDouble();
	}
	
	@Override
	public float getAsFloat() {
		return ((NBTTagByte) base).i();
	}
	
	@Override
	public String getAsString() {
		return String.valueOf(((NBTTagByte) base).g());
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseByte1_12_R1(((NBTTagByte) base).c());
	}
	
}