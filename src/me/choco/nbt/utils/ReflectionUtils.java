package me.choco.nbt.utils;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * General reflection utilities to simplify reflection calls in 
 * other classes and to store Method & Class objects in fields 
 * in order to alleviate performance drops
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ReflectionUtils {

	private static String version;
	
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
	
	public static Class<?> classNMSItemStack;
	public static Method methodItemStackSetTag, methodItemStackGetTag;

	public static Class<?> classNMSEntity;
	public static Method methodEntitySetTag, methodEntityGetTag;
	
	public static Class<?> classCraftItemStack;
	public static Method methodItemStackAsNMSCopy;
	public static Method methodItemStackAsCraftMirror;

	public static Class<?> classCraftEntity;
	public static Method methodEntityAsNMSCopy;
	public static Method methodEntityAsCraftMirror;
	
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

	public static Object getNMSEntity(Entity entity){
		Preconditions.checkNotNull(entity, "Entity cannot be null");

		try {
			return methodEntityAsNMSCopy.invoke(null, entity);
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

	public static Entity getBukkitEntity(Object nmsEntity){
		Preconditions.checkNotNull(nmsEntity, "Entity cannot be null");

		try {
			return (Entity) methodEntityAsCraftMirror.invoke(null, nmsEntity);
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
		classCraftItemStack = getCBClass("inventory.CraftItemStack");
		methodItemStackAsNMSCopy = getMethod("asNMSCopy", classCraftItemStack, ItemStack.class);
		methodItemStackAsCraftMirror = getMethod("asCraftMirror", classCraftItemStack, classNMSItemStack);
		classCraftEntity = getCBClass("entity.CraftEntity");
		methodEntityAsNMSCopy = getMethod("getHandle", classCraftEntity);
		methodEntityAsCraftMirror = getMethod("getBukkitEntity", classCraftEntity);
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