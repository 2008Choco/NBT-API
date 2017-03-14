package me.choco.nbt.utils;

@FunctionalInterface
public interface Applier<T> {
	
	public void apply(NBTModifiable nbtModifiable, String key, T value);
	
}