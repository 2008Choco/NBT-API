package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseFloat extends NBTBase {
	
	private float value;
	
	public NBTBaseFloat(float value) {
		this.value = value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseFloat(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseFloat)) return false;
		return value == ((NBTBaseFloat) tag).value;
	}
	
}