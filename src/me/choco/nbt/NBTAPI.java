package me.choco.nbt;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.choco.nbt.types.NBTEntity;
import me.choco.nbt.types.NBTItem;
import me.choco.nbt.utils.ReflectionUtils;

/**
 * An extensive NBT library to allow for easy custom modifications to
 * existing ItemStack, Entity and TileEntity objects. NBT data is managed
 * by the server, and this API is meant to interface with it and simplify
 * accessing net.minecraft.server methods.
 * <br>
 * <br> This library uses reflection, and will hardly require updates - if
 * any at all. The goal of this plugin is to allow for interaction with custom
 * NBT data, yet simultaneously maintain high performance.
 * 
 * @author Parker Hawke - 2008Choco
 * @author Contributor - iso2013
 */
public class NBTAPI extends JavaPlugin {
	
	// Bukkit implementation, (ex: 1_11_R1)
	private String bukkitVersion;
	
	@Override
	public void onEnable() {
		this.getLogger().info("Retrieving Bukkit version information");
		bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		this.getLogger().info("Bukkit implementation " + this.bukkitVersion);
		
		ReflectionUtils.loadNMSClasses(this.bukkitVersion);
	}
	
	/**
	 * Get the Bukkit implementation version for the current server (i.e. 1_11_R1)
	 * 
	 * @return Bukkit implementation version
	 */
	public String getBukkitVersion() {
		return bukkitVersion;
	}
	
	/**
	 * Get the NBT modifiable equivalent of an ItemStack
	 * 
	 * @param item - The item to modify
	 * @return a modifiable item stack
	 */
	public static NBTItem getNBTItem(ItemStack item) {
		NBTItem nbtItem = new NBTItem(item);
		if (!nbtItem.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable ItemStack");
		
		return nbtItem;
	}
	
	/**
	 * Get the NBT modifiable equivalent of an Entity
	 * 
	 * @param entity - The entity to modify
	 * @return a modifiable entity
	 */
	public static NBTEntity getNBTEntity(Entity entity) {
		NBTEntity nbtEntity = new NBTEntity(entity);
		if (!nbtEntity.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable Entity");
		
		return nbtEntity;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("itemnbt")) {
			if (!(sender instanceof Player)) return true;
			Player player = (Player) sender;
			
			ItemStack item = player.getInventory().getItemInMainHand();
			if (item == null || item.getType() == Material.AIR) {
				player.sendMessage(ChatColor.RED + "You must be holding an item");
				return true;
			}
			
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("set")) {
					if (args.length >= 2) {
						String tag = args[1];
						
						NBTItem nbtItem = NBTAPI.getNBTItem(item);
						if (nbtItem.hasKey(tag)) {
							player.sendMessage(ChatColor.RED + "The NBT tag \"" + tag + "\" is already set on this item");
							return true;
						}
						
						int value = -1;
						if (args.length >= 3)
							value = Integer.parseInt(args[2]);
						
						item = nbtItem.setInt(tag, value).getModifiedItemStack();
						player.getInventory().setItemInMainHand(item);
						player.sendMessage(ChatColor.GREEN + "An integer tag of \"" + tag + "\" has been set to " + value);
						return true;
					}
					
					else {
						player.sendMessage(ChatColor.RED + "/itemnbt set <tag> [value]");
					}
				}
				
				else if (args[0].equalsIgnoreCase("get")) {
					if (args.length >= 2) {
						String tag = args[1];
						
						NBTItem nbtItem = NBTAPI.getNBTItem(item);
						if (!nbtItem.hasKey(tag)) {
							player.sendMessage(ChatColor.RED + "The NBT tag \"" + tag + "\" is not present on this item");
							return true;
						}
						
						int value = nbtItem.getInt(tag);
						player.sendMessage(ChatColor.GREEN + "The value of \"" + tag + "\" is set to " + value);
						return true;
					}
					
					else {
						player.sendMessage(ChatColor.RED + "/itemnbt get <tag>");
					}
				}
				
				else if (args[0].equalsIgnoreCase("delete")) {
					if (args.length >= 2) {
						String tag = args[1];
						
						NBTItem nbtItem = NBTAPI.getNBTItem(item);
						if (!nbtItem.hasKey(tag)) {
							player.sendMessage(ChatColor.RED + "The NBT tag \"" + tag + "\" is not present on this item");
							return true;
						}
						
						item = nbtItem.removeKey(tag).getModifiedItemStack();
						player.getInventory().setItemInMainHand(item);
						player.sendMessage(ChatColor.GREEN + "NBT tag \"" + tag + "\" has been removed");
						return true;
					}
					
					else {
						player.sendMessage(ChatColor.RED + "/itemnbt deleted <tag>");
					}
				}
				
				else {
					player.sendMessage(ChatColor.RED + "/itemnbt <set|get|delete>");
				}
			}
			else {
				player.sendMessage(ChatColor.RED + "/itemnbt <set|get|delete>");
			}
		}
		return true;
	}
}