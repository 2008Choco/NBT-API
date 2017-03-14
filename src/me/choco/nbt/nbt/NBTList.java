package me.choco.nbt.nbt;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import me.choco.nbt.nbt.data.NBTBaseBoolean;
import me.choco.nbt.nbt.data.NBTBaseByte;
import me.choco.nbt.nbt.data.NBTBaseDouble;
import me.choco.nbt.nbt.data.NBTBaseFloat;
import me.choco.nbt.nbt.data.NBTBaseInt;
import me.choco.nbt.nbt.data.NBTBaseLong;
import me.choco.nbt.nbt.data.NBTBaseShort;
import me.choco.nbt.nbt.data.NBTBaseString;

/**
 * Represents an abstractified net.minecraft.server.NBTTagList object
 * 
 * @author Parker Hawke - 2008Choco
 */
public class NBTList extends NBTBase {
	
	private final List<NBTBase> compounds;
	
	public NBTList() {
		this.compounds = Lists.newArrayList();
	}
	
	private NBTList(List<NBTBase> compounds) {
		this.compounds = compounds;
	}
	
	@Override
	public boolean isEmpty() {
		return compounds.isEmpty();
	}
	
	@Override
	public NBTList clone() {
		return new NBTList(compounds);
	}
	
	@Override
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTList)) return false;
		return compounds.equals(((NBTList) tag).compounds);
	}
	
	public NBTList addString(String value) {
		this.compounds.add(new NBTBaseString(value));
		return this;
	}
	
	public String getString(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseString)) return null;
        
    	return ((NBTBaseString) base).getValue();
	}
	
	public NBTList addInt(int value) {
		this.compounds.add(new NBTBaseInt(value));
		return this;
	}
	
	public int getInt(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseInt)) return -1;
        
    	return ((NBTBaseInt) base).getValue();
	}
	
	public NBTList addDouble(double value) {
		this.compounds.add(new NBTBaseDouble(value));
		return this;
	}
	
	public double getDouble(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseDouble)) return -1.0;
        
    	return ((NBTBaseDouble) base).getValue();
	}
	
	public NBTList addFloat(float value) {
		this.compounds.add(new NBTBaseFloat(value));
		return this;
	}
	
	public float getFloat(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseFloat)) return -1;
        
    	return ((NBTBaseFloat) base).getValue();
	}
	
	public NBTList addShort(short value) {
		this.compounds.add(new NBTBaseShort(value));
		return this;
	}
	
	public short getShort(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseShort)) return -1;
        
    	return ((NBTBaseShort) base).getValue();
	}
	
	public NBTList addLong(long value) {
		this.compounds.add(new NBTBaseLong(value));
		return this;
	}
	
	public long getLong(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseLong)) return -1;
        
    	return ((NBTBaseLong) base).getValue();
	}
	
	public NBTList addByte(byte value) {
		this.compounds.add(new NBTBaseByte(value));
		return this;
	}
	
	public byte getByte(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseByte)) return -1;
        
    	return ((NBTBaseByte) base).getValue();
	}
	
	public NBTList addBoolean(boolean value) {
		this.compounds.add(new NBTBaseBoolean(value));
		return this;
	}
	
	public boolean getBoolean(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
        
        NBTBase base = this.compounds.get(index);
        if (base == null || !(base instanceof NBTBaseBoolean)) return false;
        
    	return ((NBTBaseBoolean) base).getValue();
	}
	
	public NBTList addNBTValue(NBTBase value) {
		this.compounds.add(value);
		return this;
	}
	
	public NBTBase getNBTValue(int index) {
		Preconditions.checkArgument(index > 0 && index < compounds.size(), "Provided index must be between 0 and " + compounds.size());
		return this.compounds.get(index);
	}
	
}