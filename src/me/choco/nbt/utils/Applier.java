package me.choco.nbt.utils;

public interface Applier<T> {
	
	public void apply(NBTModifiable nbtModifiable, String key, String value);
	
}