package me.choco.nbt;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.choco.nbt.types.NBTItem;
import me.choco.nbt.utils.ReflectionUtils;

public class NBTAPI extends JavaPlugin {
	
	private String bukkitVersion;
	
	@Override
	public void onEnable() {
		this.getLogger().info("Retrieving Bukkit version information");
		bukkitVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		this.getLogger().info("Bukkit implementation " + this.bukkitVersion);
		
		ReflectionUtils.loadNMSClasses(this.bukkitVersion);
	}
	
	public String getBukkitVersion() {
		return bukkitVersion;
	}
	
	public static NBTItem getNBTItem(ItemStack item) {
		NBTItem nbtItem = new NBTItem(item);
		if (!nbtItem.isSupported())
			throw new UnsupportedOperationException("There was an issue retrieving an NBTModifiable ItemStack");
		
		return nbtItem;
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