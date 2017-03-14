package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseInt extends NBTBase {
	
	private int value;
	
	public NBTBaseInt(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseInt(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseInt)) return false;
		return value == ((NBTBaseInt) tag).value;
	}
	
}