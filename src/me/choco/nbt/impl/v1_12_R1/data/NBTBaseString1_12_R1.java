package me.choco.nbt.impl.v1_12_R1.data;

import me.choco.nbt.impl.v1_12_R1.NBTBase1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.data.NBTBaseString;

import net.minecraft.server.v1_12_R1.NBTTagString;

public class NBTBaseString1_12_R1 extends NBTBase1_12_R1 implements NBTBaseString {
	
	public NBTBaseString1_12_R1(NBTTagString base) {
		super(base);
	}
	
	public NBTBaseString1_12_R1(String value) {
		super(new NBTTagString(value));
	}
	
	@Override
	public String getValue() {
		return ((NBTTagString) base).c_();
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBaseString1_12_R1(((NBTTagString) base).c());
	}
	
}