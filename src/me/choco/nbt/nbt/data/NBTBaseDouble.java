package me.choco.nbt.nbt.data;

import me.choco.nbt.nbt.NBTBase;

public class NBTBaseDouble extends NBTBase {
	
	private double value;
	
	public NBTBaseDouble(double value) {
		this.value = value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

	@Override
	public NBTBase clone() {
		return new NBTBaseDouble(value);
	}

	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTBaseDouble)) return false;
		return value == ((NBTBaseDouble) tag).value;
	}
	
}