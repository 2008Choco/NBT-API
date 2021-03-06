package me.choco.nbt.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.google.common.base.Preconditions;

/**
 * General reflection utilities to simplify reflection calls in 
 * other classes and to store Method & Class objects in fields 
 * in order to alleviate performance drops
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ReflectionUtils {

	private static String version;
	
	// NBTTagCompound-related Classes & Methods
	public static Class<?> classNBTBase;
	public static Class<?> classNBTTagCompound;
	public static Method methodSetString, methodGetString;
	public static Method methodSetInt, methodGetInt;
	public static Method methodSetDouble, methodGetDouble;
	public static Method methodSetFloat, methodGetFloat;
	public static Method methodSetShort, methodGetShort;
	public static Method methodSetLong, methodGetLong;
	public static Method methodSetByte, methodGetByte;
	public static Method methodSetBoolean, methodGetBoolean;
	public static Method methodHasKey;
	public static Method methodRemove;
	public static Method methodSet;
	public static Method methodGetList;
	
	public static Class<?> classNBTTagList;
	public static Method methodAdd, methodGet, methodSize;
	
	// net.minecraft.server.ItemStack Class & Methods
	public static Class<?> classNMSItemStack;
	public static Method methodItemStackSetTag, methodItemStackGetTag;

	// net.minecraft.server.Entity Class & Methods
	public static Class<?> classNMSEntity;
	public static Method methodEntitySetTag, methodEntityGetTag;
	
	// net.minecraft.server.TileEntity Class & Methods
	public static Class<?> classNMSTileEntity;
	public static Method methodTileEntitySetTag, methodTileEntityGetTag;
	public static Method methodTileEntityGetWorld, methodTileEntityGetPosition;
	
	// net.minecraft.server.BlockPosition Class & Methods
	public static Class<?> classBlockPosition;
	public static Method methodBlockPositionGetX, methodBlockPositionGetY, methodBlockPositionGetZ;
	
	public static Class<?> classWorld;
	
	// org.bukkit.craftbukkit.inventory.CraftItemStack Class & Methods
	public static Class<?> classCraftItemStack;
	public static Method methodItemStackAsNMSCopy;
	public static Method methodItemStackAsCraftMirror;

	// org.bukkit.craftbukkit.entity.CraftEntity Class & Methods
	public static Class<?> classCraftEntity;
	public static Method methodEntityAsNMSCopy;
	public static Method methodEntityAsCraftMirror;
	
	// org.bukkit.craftbukkit.block.CraftBlockState Class & Methods
	public static Class<?> classCraftBlockState;
	public static Method methodBlockStateGetTileEntity;
	public static Method methodBlockStateGetBlockState;
	
	/**
	 * Get a net.minecraft.server.ItemStack object from a Bukkit {@link ItemStack} object
	 * 
	 * @param item - The Bukkit ItemStack to convert
	 * @return the nms.ItemStack object
	 */
	public static Object getNMSItemStack(ItemStack item) {
		Preconditions.checkNotNull(item, "ItemStack cannot be null");
		
		try {
			return methodItemStackAsNMSCopy.invoke(null, item);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}

	/**
	 * Get a net.minecraft.server.Entity object from a Bukkit {@link Entity} object
	 * 
	 * @param entity - The Bukkit Entity to convert
	 * @return the nms.Entity object
	 */
	public static Object getNMSEntity(Entity entity){
		Preconditions.checkNotNull(entity, "Entity cannot be null");

		try {
			return methodEntityAsNMSCopy.invoke(null, entity);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}
	
	/**
	 * Get a net.minecraft.server.TileEntity object from a Bukkit {@link BlockState} object
	 * 
	 * @param state - The Bukkit BlockState to convert
	 * @return the nms.TileEntity object
	 */
	public static Object getNMSTileEntity(BlockState state) {
		Preconditions.checkNotNull(state, "BlockState cannot be null");
		
		try {
			return methodBlockStateGetTileEntity.invoke(state);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}
	
	/**
	 * Get a Bukkit {@link ItemStack} object from a net.minecraft.server.ItemStack object
	 * 
	 * @param nmsItem - The nms.ItemStack object
	 * @return the Bukkit ItemStack object
	 */
	public static ItemStack getBukkitItemStack(Object nmsItem) {
		Preconditions.checkNotNull(nmsItem, "ItemStack cannot be null");
		
		try {
			return (ItemStack) methodItemStackAsCraftMirror.invoke(null, nmsItem);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}

	/**
	 * Get a Bukkit {@link Entity} object from a net.minecraft.server.Entity object
	 * 
	 * @param nmsEntity - The nms.Entity object
	 * @return the Bukkit Entity object
	 */
	public static Entity getBukkitEntity(Object nmsEntity){
		Preconditions.checkNotNull(nmsEntity, "Entity cannot be null");

		try {
			return (Entity) methodEntityAsCraftMirror.invoke(null, nmsEntity);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}
	
	/**
	 * Get a Bukkit {@link BlockState} object from a net.minecraft.server.TileEntity object
	 * 
	 * @param nmsTileEntity - The nms.TileEntity object
	 * @return the Bukkit BlockState object
	 */
	public static BlockState getBukkitBlockState(Object nmsTileEntity) {
		Preconditions.checkNotNull(nmsTileEntity, "TileEntity cannot be null");
		
		try {
			Object nmsWorld = methodTileEntityGetWorld.invoke(nmsTileEntity);
			Object blockPos = methodTileEntityGetPosition.invoke(nmsTileEntity);
			
			int x = (int) methodBlockPositionGetX.invoke(blockPos);
			int y = (int) methodBlockPositionGetY.invoke(blockPos);
			int z = (int) methodBlockPositionGetZ.invoke(blockPos);
			
			return (BlockState) methodBlockStateGetBlockState.invoke(null, nmsWorld, x, y, z);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}
	
	/**
	 * Generate a new net.minecraft.server.NBTTagCompound object, the base of
	 * all NBT structures
	 * 
	 * @return an empty NBTTagCompound
	 */
	public static Object newNBTTagCompound() {
		try {
			return classNBTTagCompound.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
	/**
	 * Generate a new net.minecraft.server.NBTTagList object, an array of
	 * objects in NBT structures
	 * 
	 * @return an empty NBTTagList
	 */
	public static Object newNBTTagList() {
		try {
			return classNBTTagList.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
	/**
	 * Load all required classes and methods
	 * 
	 * @param version - Bukkit implementation version
	 */
	public static void loadNMSClasses(String version) {
		if (classCraftItemStack != null) return;
		
		ReflectionUtils.version = version + ".";
		
		classNBTBase = getNMSClass("NBTBase");
		classNBTTagCompound = getNMSClass("NBTTagCompound");
		methodSetString = getMethod("setString", classNBTTagCompound, String.class, String.class);
		methodGetString = getMethod("getString", classNBTTagCompound, String.class);
		methodSetInt = getMethod("setInt", classNBTTagCompound, String.class, Integer.TYPE);
		methodGetInt = getMethod("getInt", classNBTTagCompound, String.class);
		methodSetDouble = getMethod("setDouble", classNBTTagCompound, String.class, Double.TYPE);
		methodGetDouble = getMethod("getDouble", classNBTTagCompound, String.class);
		methodSetFloat = getMethod("setFloat", classNBTTagCompound, String.class, Float.TYPE);
		methodGetFloat = getMethod("getFloat", classNBTTagCompound, String.class);
		methodSetShort = getMethod("setShort", classNBTTagCompound, String.class, Short.TYPE);
		methodGetShort = getMethod("getShort", classNBTTagCompound, String.class);
		methodSetLong = getMethod("setLong", classNBTTagCompound, String.class, Long.TYPE);
		methodGetLong = getMethod("getLong", classNBTTagCompound, String.class);
		methodSetByte = getMethod("setByte", classNBTTagCompound, String.class, Byte.TYPE);
		methodGetByte = getMethod("getByte", classNBTTagCompound, String.class);
		methodSetBoolean = getMethod("setBoolean", classNBTTagCompound, String.class, Boolean.TYPE);
		methodGetBoolean = getMethod("getBoolean", classNBTTagCompound, String.class);
		methodHasKey = getMethod("hasKey", classNBTTagCompound, String.class);
		methodRemove = getMethod("remove", classNBTTagCompound, String.class);
		methodSet = getMethod("set", classNBTTagCompound, String.class, classNBTBase);
		methodGetList = getMethod("getList", classNBTTagCompound, String.class);
		classNBTTagList = getNMSClass("NBTTagList");
		methodAdd = getMethod("add", classNBTTagList, classNBTBase);
		methodGet = getMethod("get", classNBTTagList, Integer.TYPE);
		methodSize = getMethod("size", classNBTTagList);
		classNMSItemStack = getNMSClass("ItemStack");
		methodItemStackSetTag = getMethod("setTag", classNMSItemStack, classNBTTagCompound);
		methodItemStackGetTag = getMethod("getTag", classNMSItemStack);
		classNMSEntity = getNMSClass("Entity");
		methodEntitySetTag = getMethod("f", classNMSEntity, classNBTTagCompound);
		methodEntityGetTag = getMethod("e", classNMSEntity, classNBTTagCompound);
		classNMSTileEntity = getNMSClass("TileEntity");
		methodTileEntitySetTag = getMethod("a", classNMSTileEntity, classNBTTagCompound);
		methodTileEntityGetTag = getMethod("c", classNMSTileEntity, classNBTTagCompound);
		methodTileEntityGetWorld = getMethod("getWorld", classNMSTileEntity);
		methodTileEntityGetPosition = getMethod("getPosition", classNMSTileEntity);
		classBlockPosition = getNMSClass("BlockPosition");
		methodBlockPositionGetX = getMethod("getX", classBlockPosition);
		methodBlockPositionGetY = getMethod("getY", classBlockPosition);
		methodBlockPositionGetZ = getMethod("getZ", classBlockPosition);
		classWorld = getNMSClass("World");
		classCraftItemStack = getCBClass("inventory.CraftItemStack");
		methodItemStackAsNMSCopy = getMethod("asNMSCopy", classCraftItemStack, ItemStack.class);
		methodItemStackAsCraftMirror = getMethod("asCraftMirror", classCraftItemStack, classNMSItemStack);
		classCraftEntity = getCBClass("entity.CraftEntity");
		methodEntityAsNMSCopy = getMethod("getHandle", classCraftEntity);
		methodEntityAsCraftMirror = getMethod("getBukkitEntity", classCraftEntity);
		classCraftBlockState = getCBClass("block.CraftBlockState");
		methodBlockStateGetTileEntity = getMethod("getTileEntity", classCraftBlockState);
		methodBlockStateGetBlockState = getMethod("getTileEntity", classCraftBlockState, classWorld, Integer.TYPE, Integer.TYPE, Integer.TYPE);
	}
	
	/**
	 * Get a method from a specific class
	 * 
	 * @param name - The name of the method
	 * @param clazz - The class in which the method is located
	 * @param paramTypes - The parameter types accepted by this method
	 * @return an instance of the method, or null if not found
	 */
	private static Method getMethod(String name, Class<?> clazz, Class<?>... paramTypes) {
		try {
			return clazz.getMethod(name, paramTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("Could not find method " + name + " in " + clazz.getSimpleName());
		}
		return null;
	}
	
	/**
	 * Get a class object from the net.minecraft.server package
	 * 
	 * @param className - The name of the class
	 * @return the NMS class object, or null if not found
	 */
    private static Class<?> getNMSClass(String className) {
        try {
        	return Class.forName("net.minecraft.server." + version + className);
        } catch (Exception e) {
			System.out.println("Could not find class " + className);
        }
        return null;
    }
    
	/**
	 * Get a class object from the org.bukkit.craftbukkit package
	 * 
	 * @param className - The name of the class
	 * @return the CraftBukkit class object, or null if not found
	 */
    private static Class<?> getCBClass(String className) {
        try {
        	return Class.forName("org.bukkit.craftbukkit." + version + className);
        } catch (Exception e) {
			System.out.println("Could not find class " + className);
        }
        return null;
    }
	
}