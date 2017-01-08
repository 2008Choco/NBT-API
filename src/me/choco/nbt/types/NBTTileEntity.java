package me.choco.nbt.types;

import static me.choco.nbt.utils.ReflectionUtils.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.block.BlockState;

import com.google.common.base.Preconditions;

import me.choco.nbt.utils.NBTModifiable;

public class NBTTileEntity<T extends BlockState> implements NBTModifiable {
	
	private final Object nmsTileEntity;
	
	public NBTTileEntity(T blockState) {
		Preconditions.checkNotNull(blockState, "Cannot modify the NBT of a null BlockState");
		this.nmsTileEntity = getNMSTileEntity(blockState);
	}

	@Override
	public boolean isSupported() {
		return this.nmsTileEntity != null;
	}

	@Override
	public NBTModifiable removeKey(String key) {
		Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");

        try {
            Object nbt = methodTileEntityGetTag.invoke(nmsTileEntity);
            if (nbt == null) return this;
            
            methodRemove.invoke(nbt, key);
            methodTileEntitySetTag.invoke(nmsTileEntity, this);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return this;
	}

	@Override
	public boolean hasKey(String key) {
        if (key == null) return false;
        boolean hasTag = false;

        try {
            Object nbt = methodTileEntityGetTag.invoke(nmsTileEntity);
            if (nbt == null) return false;

            hasTag = (boolean) methodHasKey.invoke(nbt, key);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return hasTag;
	}

	@Override
    public NBTModifiable setString(String key, String value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetString, key, value);
        return this;
    }

    @Override
    public String getString(String key) {
        if (key == null) return null;
        return this.getNBTValue(methodGetString, key, String.class, "");
    }

    @Override
    public NBTModifiable setInt(String key, int value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetInt, key, value);
        return this;
    }

    @Override
    public int getInt(String key) {
        if (key == null) return -1;
        return this.getNBTValue(methodGetInt, key, Integer.class, -1);
    }

    @Override
    public NBTModifiable setDouble(String key, double value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetDouble, key, value);
        return this;
    }

    @Override
    public double getDouble(String key) {
        if (key == null) return -1;
        return this.getNBTValue(methodGetDouble, key, Double.class, -1d);
    }

    @Override
    public NBTModifiable setFloat(String key, float value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetFloat, key, value);
        return this;
    }

    @Override
    public float getFloat(String key) {
        if (key == null) return -1;
        return this.getNBTValue(methodGetFloat, key, Float.class, -1f);
    }

    @Override
    public NBTModifiable setShort(String key, short value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetShort, key, value);
        return this;
    }

    @Override
    public short getShort(String key) {
        if (key == null) return -1;
        return this.getNBTValue(methodGetShort, key, Short.class, (short) -1);
    }

    @Override
    public NBTModifiable setLong(String key, long value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetLong, key, value);
        return this;
    }

    @Override
    public long getLong(String key) {
        if (key == null) return -1;
        return this.getNBTValue(methodGetLong, key, Long.class, -1L);
    }

    @Override
    public NBTModifiable setByte(String key, byte value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetByte, key, value);
        return this;
    }

    @Override
    public byte getByte(String key) {
        if (key == null) return -1;
        return this.getNBTValue(methodGetByte, key, Byte.class, (byte) -1);
    }

    @Override
    public NBTModifiable setBoolean(String key, boolean value) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");
        this.setNBTValue(methodSetBoolean, key, value);
        return this;
    }
    
    @Override
    public boolean getBoolean(String key) {
        if (key == null) return false;
        return this.getNBTValue(methodGetBoolean, key, Boolean.class, false);
    }
	
    private <M> void setNBTValue(Method method, String key, M value) {
        try {
            Object nbt = methodEntityGetTag.invoke(nmsTileEntity);
            if (nbt == null) nbt = newNBTTagCompound();

            method.invoke(nbt, key, value);
            methodEntitySetTag.invoke(nmsTileEntity, nbt);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private <M> M getNBTValue(Method method, String key, Class<M> returnType, M defaultValue) {
        try {
            Object nbt = methodEntityGetTag.invoke(nmsTileEntity);
            if (nbt == null) return defaultValue;

            return returnType.cast(method.invoke(nbt, key));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return defaultValue;
        }
    }
    
}