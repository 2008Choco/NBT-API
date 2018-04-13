package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBaseIntArray;

import net.minecraft.server.v1_12_R1.NBTTagIntArray;

public class NBTBaseIntArray1_12_R1 extends NBTBase1_12_R1 implements NBTBaseIntArray {
	
	public NBTBaseIntArray1_12_R1(NBTTagIntArray tag) {
		super(tag);
	}
	
	public NBTBaseIntArray1_12_R1(int... values) {
		super(new NBTTagIntArray(values));
	}
	
	@Override
	public int[] getValue() {
		return ((NBTTagIntArray) base).d();
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseIntArray1_12_R1(((NBTTagIntArray) base).c());
	}
	
}