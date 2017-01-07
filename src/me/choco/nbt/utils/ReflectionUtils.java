package me.choco.nbt.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.inventory.ItemStack;

import com.google.common.base.Preconditions;

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
	public static Method methodAdd;
	public static Method methodGet;
	public static Method methodSize;
	
	public static Class<?> classNMSItemStack;
	public static Method methodSetTag, methodGetTag;
	
	public static Class<?> classCraftItemStack;
	public static Method methodAsNMSCopy;
	public static Method methodAsCraftMirror;
	
	public static Object getNMSItemStack(ItemStack item) {
		Preconditions.checkNotNull(item, "ItemStack cannot be null");
		
		try {
			return methodAsNMSCopy.invoke(null, item);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}
	
	public static ItemStack getBukkitItemStack(Object nmsItem) {
		Preconditions.checkNotNull(nmsItem, "ItemStack cannot be null");
		
		try {
			return (ItemStack) methodAsCraftMirror.invoke(null, nmsItem);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
	}
	
	public static Object newNBTTagCompound() {
		try {
			return classNBTTagCompound.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
	public static Object newNBTTagList() {
		try {
			return classNBTTagList.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
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
		methodSetTag = getMethod("setTag", classNMSItemStack, classNBTTagCompound);
		methodGetTag = getMethod("getTag", classNMSItemStack);
		classCraftItemStack = getCBClass("inventory.CraftItemStack");
		methodAsNMSCopy = getMethod("asNMSCopy", classCraftItemStack, ItemStack.class);
		methodAsCraftMirror = getMethod("asCraftMirror", classCraftItemStack, classNMSItemStack);
	}
	
	private static Method getMethod(String name, Class<?> clazz, Class<?>... paramTypes) {
		try {
			return clazz.getMethod(name, paramTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("Could not find method " + name + " in " + clazz.getSimpleName());
		}
		return null;
	}
	
    private static Class<?> getNMSClass(String className) {
        try {
        	return Class.forName("net.minecraft.server." + version + className);
        } catch (Exception e) {
			System.out.println("Could not find class " + className);
        }
        return null;
    }
    
    private static Class<?> getCBClass(String className) {
        try {
        	return Class.forName("org.bukkit.craftbukkit." + version + className);
        } catch (Exception e) {
			System.out.println("Could not find class " + className);
        }
        return null;
    }
	
}