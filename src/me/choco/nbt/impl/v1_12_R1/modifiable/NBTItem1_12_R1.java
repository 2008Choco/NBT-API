package me.choco.nbt.impl.v1_12_R1.modifiable;

import com.google.common.base.Preconditions;

import me.choco.nbt.impl.v1_12_R1.NBTCompound1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.types.NBTItem;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class NBTItem1_12_R1 implements NBTItem {
	
	private boolean acceptingManipulation = true;
	private ItemStack modifiedStack;
	
	private final net.minecraft.server.v1_12_R1.ItemStack nmsItem;
	private NBTCompound root;
	
	public NBTItem1_12_R1(ItemStack item) {
		Preconditions.checkArgument(item != null, "Cannot create NBTItem for null ItemStack");
		
		this.nmsItem = CraftItemStack.asNMSCopy(item);
		this.root = new NBTCompound1_12_R1(this.nmsItem.getTag());
	}
	
	@Override
	public boolean isSupported() {
		return nmsItem != null && !nmsItem.isEmpty() && root != null;
	}
		
	@Override
	public ItemStack getModifiedItemStack() {
		if (modifiedStack != null) return modifiedStack;
		
		this.nmsItem.setTag((NBTTagCompound) root.toNMS());
		this.modifiedStack = CraftItemStack.asCraftMirror(nmsItem);
		this.acceptingManipulation = false;
		
		return modifiedStack;
	}
	
	@Override
	public NBTItem removeKey(String key) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.removeKey(key);
		return this;
	}
	
	@Override
	public boolean hasKey(String key) {
		return root.hasKey(key);
	}
	
	@Override
	public NBTItem setString(String key, String value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setString(key, value);
		return this;
	}
	
	@Override
	public String getString(String key) {
		return root.getString(key);
	}
	
	@Override
	public NBTItem setInt(String key, int value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setInt(key, value);
		return this;
	}
	
	@Override
	public int getInt(String key) {
		return root.getInt(key);
	}
	
	@Override
	public NBTItem setDouble(String key, double value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setDouble(key, value);
		return this;
	}
	
	@Override
	public double getDouble(String key) {
		return root.getDouble(key);
	}
	
	@Override
	public NBTItem setFloat(String key, float value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setFloat(key, value);
		return this;
	}
	
	@Override
	public float getFloat(String key) {
		return root.getFloat(key);
	}
	
	@Override
	public NBTItem setShort(String key, short value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setShort(key, value);
		return this;
	}
	
	@Override
	public short getShort(String key) {
		return root.getShort(key);
	}
	
	@Override
	public NBTItem setLong(String key, long value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setLong(key, value);
		return this;
	}
	
	@Override
	public long getLong(String key) {
		return root.getLong(key);
	}
	
	@Override
	public NBTItem setByte(String key, byte value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setByte(key, value);
		return this;
	}
	
	@Override
	public byte getByte(String key) {
		return root.getByte(key);
	}
	
	@Override
	public NBTItem setBoolean(String key, boolean value) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setBoolean(key, value);
		return this;
	}
	
	@Override
	public boolean getBoolean(String key) {
		return root.getBoolean(key);
	}
	
	@Override
	public NBTItem setIntArray(String key, int[] value) {
		this.root.setIntArray(key, value);
		return this;
	}
	
	@Override
	public int[] getIntArray(String key) {
		return root.getIntArray(key);
	}
	
	@Override
	public NBTItem setByteArray(String key, byte[] value) {
		this.root.setByteArray(key, value);
		return this;
	}
	
	@Override
	public byte[] getByteArray(String key) {
		return root.getByteArray(key);
	}
	
	@Override
	public NBTItem setNBTValue(String key, NBTBase nbtTag) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root.setNBTValue(key, nbtTag);
		return this;
	}
	
	@Override
	public NBTBase getNBTValue(String key) {
		return root.getNBTValue(key);
	}
	
	@Override
	public NBTItem setTag(NBTCompound compound) {
		Preconditions.checkArgument(acceptingManipulation, "No longer accepting NBT edit invocations. Get a new instance of NBTItem");
		
		this.root = (compound != null) ? compound : new NBTCompound1_12_R1();
		return this;
	}
	
	@Override
	public NBTCompound getTag() {
		return (NBTCompound) root.clone();
	}
	
}