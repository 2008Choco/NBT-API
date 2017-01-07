package me.choco.nbt.types;

import static me.choco.nbt.utils.ReflectionUtils.*;

import org.bukkit.block.BlockState;

import com.google.common.base.Preconditions;

import me.choco.nbt.utils.NBTModifiable;

public class NBTTileEntity<T extends BlockState> implements NBTModifiable {
	
	@SuppressWarnings("unused")
	private final T blockState;
	private final Object nmsTileEntity;
	
	public NBTTileEntity(T blockState) {
		Preconditions.checkNotNull(blockState, "Cannot modify the NBT of a null BlockState");
		
		this.blockState = blockState;
		this.nmsTileEntity = getNMSTileEntity(blockState);
	}

	@Override
	public boolean isSupported() {
		return this.nmsTileEntity != null;
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