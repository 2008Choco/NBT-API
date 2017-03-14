package me.choco.nbt.nbt;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import me.choco.nbt.nbt.data.NBTBaseBoolean;
import me.choco.nbt.nbt.data.NBTBaseByte;
import me.choco.nbt.nbt.data.NBTBaseDouble;
import me.choco.nbt.nbt.data.NBTBaseFloat;
import me.choco.nbt.nbt.data.NBTBaseInt;
import me.choco.nbt.nbt.data.NBTBaseLong;
import me.choco.nbt.nbt.data.NBTBaseShort;
import me.choco.nbt.nbt.data.NBTBaseString;

/**
 * Represents an abstractified net.minecraft.server.NBTTagCompound object
 * 
 * @author Parker Hawke - 2008Choco
 */
public class NBTCompound extends NBTBase {
	
	private final Map<String, NBTBase> compounds;
	
	public NBTCompound() {
		this.compounds = Maps.newHashMap();
	}
	
	private NBTCompound(Map<String, NBTBase> compounds) {
		this.compounds = compounds;
	}

	public boolean isEmpty() {
		return compounds.isEmpty();
	}
	
	public NBTCompound clone() {
		return new NBTCompound(compounds);
	}
	
	public boolean equals(Object tag) {
		if (!(tag instanceof NBTCompound)) return false;
		return compounds.equals(((NBTCompound) tag).compounds);
	}
	
	public NBTCompound removeKey(String key) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.remove(key);
        return this;
	}

	public boolean hasKey(String key) {
        if (key == null) return false;
        return this.compounds.containsKey(key);
	}

    public NBTCompound setString(String key, String value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseString(value));
        return this;
    }

    public String getString(String key) {
        if (key == null) return null;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseString)) return null;
        
    	return ((NBTBaseString) base).getValue();
    }

    public NBTCompound setInt(String key, int value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseInt(value));
        return this;
    }

    public int getInt(String key) {
        if (key == null) return -1;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseInt)) return -1;
        
    	return ((NBTBaseInt) base).getValue();
    }

    public NBTCompound setDouble(String key, double value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseDouble(value));
        return this;
    }

    public double getDouble(String key) {
        if (key == null) return -1.0;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseDouble)) return -1.0;
        
    	return ((NBTBaseDouble) base).getValue();
    }

    public NBTCompound setFloat(String key, float value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseFloat(value));
        return this;
    }

    public float getFloat(String key) {
        if (key == null) return -1;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseFloat)) return -1;
        
    	return ((NBTBaseFloat) base).getValue();
    }

    public NBTCompound setShort(String key, short value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseShort(value));
        return this;
    }

    public short getShort(String key) {
        if (key == null) return -1;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseShort)) return -1;
        
    	return ((NBTBaseShort) base).getValue();
    }

    public NBTCompound setLong(String key, long value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseFloat(value));
        return this;
    }

    public long getLong(String key) {
        if (key == null) return -1;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseLong)) return -1;
        
    	return ((NBTBaseLong) base).getValue();
    }

    public NBTCompound setByte(String key, byte value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseByte(value));
        return this;
    }

    public byte getByte(String key) {
        if (key == null) return -1;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseByte)) return -1;
        
    	return ((NBTBaseByte) base).getValue();
    }

    public NBTCompound setBoolean(String key, boolean value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, new NBTBaseBoolean(value));
        return this;
    }
    
    public boolean getBoolean(String key) {
        if (key == null) return false;
        
        NBTBase base = this.compounds.get(key);
        if (base == null || !(base instanceof NBTBaseBoolean)) return false;
        
    	return ((NBTBaseBoolean) base).getValue();
    }

	public NBTCompound setNBTValue(String key, NBTBase value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.compounds.put(key, value);
		return this;
	}

	public NBTBase getNBTValue(String key) {
        if (key == null) return null;
		return this.compounds.get(key);
	}
	
}