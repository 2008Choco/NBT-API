package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseString extends NBTBase {
	
	private String value;
	
	public NBTBaseString(String value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseString(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseString)) return false;
		return value == ((NBTBaseString) tag).value;
	}
	
}