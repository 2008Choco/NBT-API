package me.choco.nbt.impl.v1_12_R1;

import me.choco.nbt.NBTAPI;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseByte1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseByteArray1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseDouble1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseFloat1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseInt1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseIntArray1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseLong1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseShort1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseString1_12_R1;
import me.choco.nbt.impl.v1_12_R1.modifiable.NBTItem1_12_R1;
import me.choco.nbt.nbt.NBTBase;
import me.choco.nbt.nbt.NBTCompound;
import me.choco.nbt.nbt.NBTList;
import me.choco.nbt.nbt.data.NBTDataType;
import me.choco.nbt.types.NBTItem;

import org.bukkit.inventory.ItemStack;

public class NBTUtils1_12_R1 implements NBTAPI {
	
	@Override
	public NBTCompound newNBTCompound() {
		return new NBTCompound1_12_R1();
	}
	
	@Override
	public NBTList newNBTList() {
		return new NBTList1_12_R1();
	}
	
	@Override
	public <T> NBTBase createNBTBase(NBTDataType<T> type, T value) {
		if (type == NBTDataType.STRING) return new NBTBaseString1_12_R1((String) value);
		if (type == NBTDataType.INT) return new NBTBaseInt1_12_R1((int) value);
		if (type == NBTDataType.DOUBLE) return new NBTBaseDouble1_12_R1((double) value);
		if (type == NBTDataType.FLOAT) return new NBTBaseFloat1_12_R1((float) value);
		if (type == NBTDataType.SHORT) return new NBTBaseShort1_12_R1((short) value);
		if (type == NBTDataType.LONG) return new NBTBaseLong1_12_R1((long) value);
		if (type == NBTDataType.BYTE) return new NBTBaseByte1_12_R1((byte) value);
		if (type == NBTDataType.INT_ARRAY) return new NBTBaseIntArray1_12_R1((int[]) value);
		if (type == NBTDataType.BYTE_ARRAY) return new NBTBaseByteArray1_12_R1((byte[]) value);
		if (type == NBTDataType.NBT_COMPOUND) return new NBTCompound1_12_R1();
		if (type == NBTDataType.NBT_LIST) return new NBTList1_12_R1();
		
		return null;
	}
	
	@Override
	public NBTItem getNBTItem(ItemStack item) {
		return new NBTItem1_12_R1(item);
	}
	
}