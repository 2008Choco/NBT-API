package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseBoolean extends NBTBase {
	
	private boolean value;
	
	public NBTBaseBoolean(boolean value) {
		this.value = value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseBoolean(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseBoolean)) return false;
		return value == ((NBTBaseBoolean) tag).value;
	}
	
}