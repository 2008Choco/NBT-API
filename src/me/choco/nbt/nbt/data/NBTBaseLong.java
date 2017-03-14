package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseLong extends NBTBase {
	
	private long value;
	
	public NBTBaseLong(long value) {
		this.value = value;
	}
	
	public void setValue(long value) {
		this.value = value;
	}
	
	public long getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseLong(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseLong)) return false;
		return value == ((NBTBaseLong) tag).value;
	}
	
}