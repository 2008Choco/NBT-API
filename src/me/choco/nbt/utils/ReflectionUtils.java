package me.choco.nbt.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.inventory.ItemStack;

import com.google.common.base.Preconditions;

public class ReflectionUtils {

	private static String version;
	
	public static Class<?> classCraftItemStack;
	public static Method methodAsNMSCopy;
	public static Class<?> classNBTBase;
	public static Class<?> classNBTTagCompound;
	public static Method methodSetString;
	public static Method methodGetString;
	public static Method methodHasKey;
	public static Method methodRemove;
	public static Method methodSet;
	public static Method methodGetList;
	public static Class<?> classNBTTagList;
	public static Method methodAdd;
	public static Method methodGet;
	public static Method methodSize;
	public static Class<?> classNMSItemStack;
	public static Method methodGetTag;
	public static Method methodSetTag;
	
	public static Object getNMSItemStack(ItemStack item) {
		Preconditions.checkNotNull(item, "ItemStack cannot be null");
		
		try {
			return methodAsNMSCopy.invoke(null, item);
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
	
	public static void loadNMSClasses() {
		if (classCraftItemStack != null) return;
		
		classCraftItemStack = getCBClass("CraftItemStack");
		methodAsNMSCopy = getMethod("asNMSCopy", classCraftItemStack, ItemStack.class);
		classNBTBase = getNMSClass("NBTBase");
		classNBTTagCompound = getNMSClass("NBTTagCompound");
		methodGetString = getMethod("getString", classNBTTagCompound, String.class);
		methodSetString = getMethod("setString", classNBTTagCompound, String.class, String.class);
		methodHasKey = getMethod("hasKey", classNBTTagCompound, String.class);
		methodRemove = getMethod("remove", classNBTTagCompound, String.class);
		methodSet = getMethod("set", classNBTTagCompound, String.class, classNBTBase);
		methodGetList = getMethod("getList", classNBTTagCompound, String.class);
		classNBTTagList = getNMSClass("NBTTagList");
		methodAdd = getMethod("add", classNBTTagList, classNBTBase);
		methodGet = getMethod("get", classNBTTagList, Integer.TYPE);
		methodSize = getMethod("size", classNBTTagList);
		classNMSItemStack = getNMSClass("ItemStack");
		methodGetTag = getMethod("getTag", classNMSItemStack);
		methodSetTag = getMethod("setTag", classNMSItemStack, classNBTTagCompound);
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