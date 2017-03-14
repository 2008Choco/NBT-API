package me.choco.nbt.nbt;

import me.choco.nbt.utils.NBTModifiable;

/**
 * Represents an abstractified net.minecraft.server.NBTTagCompound object
 * 
 * @author Parker Hawke - 2008Choco
 */
public class NBTCompound extends NBTBase {

	@Override
	public boolean isEmpty() {
		return false;
	}
	
	@Override
	public NBTCompound clone() {
		return null;
	}
	
	@Override
	public boolean equals(Object tag) {
		return false;
	}
	
	@Override
	public NBTModifiable removeKey(String key) {
        return this;
	}

	@Override
	public boolean hasKey(String key) {
        return true;
	}

	@Override
    public NBTModifiable setString(String key, String value) {
        return this;
    }

    @Override
    public String getString(String key) {
    	return null;
    }

    @Override
    public NBTModifiable setInt(String key, int value) {
        return this;
    }

    @Override
    public int getInt(String key) {
    	return -1;
    }

    @Override
    public NBTModifiable setDouble(String key, double value) {
        return this;
    }

    @Override
    public double getDouble(String key) {
    	return -1.0;
    }

    @Override
    public NBTModifiable setFloat(String key, float value) {
        return this;
    }

    @Override
    public float getFloat(String key) {
    	return -1;
    }

    @Override
    public NBTModifiable setShort(String key, short value) {
        return this;
    }

    @Override
    public short getShort(String key) {
    	return -1;
    }

    @Override
    public NBTModifiable setLong(String key, long value) {
        return this;
    }

    @Override
    public long getLong(String key) {
    	return -1;
    }

    @Override
    public NBTModifiable setByte(String key, byte value) {
        return this;
    }

    @Override
    public byte getByte(String key) {
    	return -1;
    }

    @Override
    public NBTModifiable setBoolean(String key, boolean value) {
        return this;
    }
    
    @Override
    public boolean getBoolean(String key) {
    	return true;
    }

	@Override
	public NBTModifiable setNBTValue(String key, NBTBase nbtTag) {
		return null;
	}

	@Override
	public NBTBase getNBTValue(String key) {
		return null;
	}
	
}