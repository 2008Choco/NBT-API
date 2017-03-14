package me.choco.nbt.types;

import static me.choco.nbt.utils.ReflectionUtils.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.Preconditions;

import org.bukkit.entity.Entity;

import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.utils.NBTModifiable;

/**
 * An Entity object with modifiable NBT data
 *
 * @author iso2013
 */
public class NBTEntity implements NBTModifiable {
	
    private final Object nmsEntity;

    /**
     * Create a new instance of an Entity with modifiable NBT data
     * 
     * @param entity - The Bukkit Entity
     */
    public NBTEntity(Entity entity) {
        Preconditions.checkNotNull(entity, "Cannot modify the NBT of a null Entity");
        this.nmsEntity = getNMSEntity(entity);
    }

    @Override
    public boolean isSupported() {
        return this.nmsEntity != null;
    }
    
    @Override
    public NBTModifiable removeKey(String key) {
        Preconditions.checkArgument(key != null && key.length() > 0, "Provided key cannot be null");

        try {
            Object nbt = methodEntityGetTag.invoke(nmsEntity);
            if (nbt == null) return this;
            
            methodRemove.invoke(nbt, key);
            methodEntitySetTag.invoke(nmsEntity, this);
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
            Object nbt = methodEntityGetTag.invoke(nmsEntity);
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

	@Override
	public NBTModifiable setNBTValue(String key, NBTBase nbtTag) {
		return null;
	}

	@Override
	public NBTBase getNBTValue(String key) {
		return null;
	}

	/**
	 * Set a value in the entity's NBT structure
	 * 
	 * @param method - The reflected method to call. Should be a set method
	 * @param key - The key to set
	 * @param value - The value to set
	 */
    private <T> void setNBTValue(Method method, String key, T value) {
        try {
            Object nbt = methodEntityGetTag.invoke(nmsEntity);
            if (nbt == null) nbt = newNBTTagCompound();

            method.invoke(nbt, key, value);
            methodEntitySetTag.invoke(nmsEntity, nbt);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Get a value in the entity's NBT structure
	 * 
	 * @param method - The reflected method to call. Should be a get method
	 * @param key - The key to get
	 * @param returnType - The type of object that will be returned
	 * @param defaultValue - The default value to return if no value was present
	 * @return the value of the key, or the default value if not found
	 */
    private <T> T getNBTValue(Method method, String key, Class<T> returnType, T defaultValue) {
        try {
            Object nbt = methodEntityGetTag.invoke(nmsEntity);
            if (nbt == null) return defaultValue;

            return returnType.cast(method.invoke(nbt, key));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return defaultValue;
        }
    }
}
