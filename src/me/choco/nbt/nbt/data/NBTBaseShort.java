package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseShort extends NBTBase {
	
	private short value;
	
	public NBTBaseShort(short value) {
		this.value = value;
	}
	
	public void setValue(short value) {
		this.value = value;
	}
	
	public short getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseShort(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseShort)) return false;
		return value == ((NBTBaseShort) tag).value;
	}
	
}