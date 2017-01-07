package me.choco.nbt.types;

import com.google.common.base.Preconditions;
import me.choco.nbt.utils.NBTModifiable;
import org.bukkit.entity.Entity;

import static me.choco.nbt.utils.ReflectionUtils.getNMSEntity;

/**
 * @author iso2013
 */
public class NBTEntity implements NBTModifiable {
    private final Entity entity;
    private final Object nmsEntity;

    public NBTEntity(Entity entity) {
        Preconditions.checkNotNull(entity, "Cannot modify the NBT of a null ItemStack");

        this.entity = entity;
        this.nmsEntity = getNMSEntity(entity);
    }


    @Override
    public boolean isSupported() {
        return false;
    }

    @Override
    public NBTModifiable removeKey(String key) {
        return null;
    }

    @Override
    public boolean hasKey(String key) {
        return false;
    }

    @Override
    public NBTModifiable setString(String key, String value) {
        return null;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public NBTModifiable setInt(String key, int value) {
        return null;
    }

    @Override
    public int getInt(String key) {
        return 0;
    }

    @Override
    public NBTModifiable setDouble(String key, double value) {
        return null;
    }

    @Override
    public double getDouble(String key) {
        return 0;
    }

    @Override
    public NBTModifiable setFloat(String key, float value) {
        return null;
    }

    @Override
    public float getFloat(String key) {
        return 0;
    }

    @Override
    public NBTModifiable setShort(String key, short value) {
        return null;
    }

    @Override
    public short getShort(String key) {
        return 0;
    }

    @Override
    public NBTModifiable setLong(String key, long value) {
        return null;
    }

    @Override
    public long getLong(String key) {
        return 0;
    }

    @Override
    public NBTModifiable setByte(String key, byte value) {
        return null;
    }

    @Override
    public byte getByte(String key) {
        return 0;
    }

    @Override
    public NBTModifiable setBoolean(String key, boolean value) {
        return null;
    }

    @Override
    public boolean getBoolean(String key) {
        return false;
    }
}
