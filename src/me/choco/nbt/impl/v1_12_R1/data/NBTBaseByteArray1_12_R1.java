package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBaseByteArray;

import net.minecraft.server.v1_12_R1.NBTTagByteArray;

public class NBTBaseByteArray1_12_R1 extends NBTBase1_12_R1 implements NBTBaseByteArray {
	
	public NBTBaseByteArray1_12_R1(NBTTagByteArray tag) {
		super(tag);
	}
	
	public NBTBaseByteArray1_12_R1(byte... values) {
		super(new NBTTagByteArray(values));
	}
	
	@Override
	public byte[] getValue() {
		return ((NBTTagByteArray) base).c();
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseByteArray1_12_R1(((NBTTagByteArray) base).c());
	}
	
}