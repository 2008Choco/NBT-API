package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseByte extends NBTBase {
	
	private byte value;
	
	public NBTBaseByte(byte value) {
		this.value = value;
	}
	
	public void setValue(byte value) {
		this.value = value;
	}
	
	public byte getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseByte(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseByte)) return false;
		return value == ((NBTBaseByte) tag).value;
	}
	
}