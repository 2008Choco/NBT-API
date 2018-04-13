package me.choco.nbt.impl.v1_12_R1;

import me.choco.nbt.impl.v1_12_R1.data.NBTBaseByte1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseDouble1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseFloat1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseInt1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseLong1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseShort1_12_R1;
import me.choco.nbt.impl.v1_12_R1.data.NBTBaseString1_12_R1;
import me.choco.nbt.nbt.NBTBase;

import net.minecraft.server.v1_12_R1.NBTTagByte;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagDouble;
import net.minecraft.server.v1_12_R1.NBTTagFloat;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagLong;
import net.minecraft.server.v1_12_R1.NBTTagShort;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class NBTBase1_12_R1 implements NBTBase {
	
	protected final net.minecraft.server.v1_12_R1.NBTBase base;
	
	public NBTBase1_12_R1(net.minecraft.server.v1_12_R1.NBTBase base) {
		this.base = base;
	}
	
	@Override
	public NBTBase clone() {
		return new NBTBase1_12_R1(base.clone());
	}
	
	@Override
	public final boolean isEmpty() {
		return base.isEmpty();
	}
	
	@Override
	public final Object toNMS() {
		return base;
	}
	
	protected final NBTBase1_12_R1 fromNMSBase(net.minecraft.server.v1_12_R1.NBTBase base) {
		if (base instanceof NBTTagByte) {
			return new NBTBaseByte1_12_R1((NBTTagByte) base);
		} else if (base instanceof NBTTagDouble) {
			return new NBTBaseDouble1_12_R1((NBTTagDouble) base);
		} else if (base instanceof NBTTagFloat) {
			return new NBTBaseFloat1_12_R1((NBTTagFloat) base);
		} else if (base instanceof NBTTagInt) {
			return new NBTBaseInt1_12_R1((NBTTagInt) base);
		} else if (base instanceof NBTTagLong) {
			return new NBTBaseLong1_12_R1((NBTTagLong) base);
		} else if (base instanceof NBTTagShort) {
			return new NBTBaseShort1_12_R1((NBTTagShort) base);
		} else if (base instanceof NBTTagString) {
			return new NBTBaseString1_12_R1((NBTTagString) base);
		} else if (base instanceof NBTTagCompound) {
			return new NBTCompound1_12_R1((NBTTagCompound) base);
		} else if (base instanceof NBTTagList) {
			return new NBTList1_12_R1((NBTTagList) base);
		}
		
		return null;
	}
	
}