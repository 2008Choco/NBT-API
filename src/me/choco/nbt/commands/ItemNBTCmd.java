package me.choco.nbt.commands;

import me.choco.nbt.NBTAPIPlugin;
import me.choco.nbt.nbt.data.NBTDataType;
import me.choco.nbt.types.NBTItem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemNBTCmd implements CommandExecutor {
	
	private static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.AQUA + "NBT" + ChatColor.GREEN + "API" + ChatColor.GRAY + "] ";
	
	/* Command Structure:
	 *   /itemnbt
	 *       set <tag> <type> <value>
	 *       remove <tag>
	 *       check <tag>
	 *           [ispresent] - default
	 *           isoftype <type>
	 */
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players are permitted to run this command");
			return true;
		}
		
		Player player = (Player) sender;
		ItemStack item = player.getInventory().getItemInMainHand(); // TODO: Multi-version support
		if (item == null) {
			player.sendMessage(PREFIX + ChatColor.RED + "You must be holding an item in your hand to perform this command");
			return true;
		}
		
		if (args.length >= 1) {
			NBTItem nbtItem = NBTAPIPlugin.getNBTItem(item);
			
			if (args[0].equalsIgnoreCase("set")) {
				if (args.length >= 2) {
					String key = args[1];
					
					if (args.length >= 3) {
						NBTDataType<?> type = NBTDataType.getByName(args[2]);
						if (type == null) {
							player.sendMessage(PREFIX + ChatColor.RED + "Invalid NBT data type, " + ChatColor.DARK_RED + args[2]);
							return true;
						}
						
						if (args.length >= 4) {
							String value = args[3];
							
							// TODO: In most cases, this will cause a ClassCastException
							type.applyToNBTModifiableGeneric(nbtItem, key, value);
							player.getInventory().setItemInMainHand((item = nbtItem.getModifiedItemStack()));
							player.sendMessage(PREFIX + ChatColor.GREEN + "NBT tag \"" + key + "\" applied to item with value of \"" + value + "\"");
						}
						else {
							player.sendMessage(PREFIX + ChatColor.RED + "Missing value. " + ChatColor.DARK_RED + "/itemnbt set " + key + " " + args[2] + " <value>");
						}
					}
					else {
						player.sendMessage(ChatColor.RED + "Missing type value. " + ChatColor.DARK_RED + "/itemnbt set " + key + " <value>");
					}
				}
				else {
					player.sendMessage(ChatColor.RED + "Missing key value. " + ChatColor.DARK_RED + "/itemnbt set <key> <type> <value>");
				}
			}
			
			else if (args[0].equalsIgnoreCase("remove")) {
				if (args.length >= 2) {
					String key = args[1];
					
					if (!nbtItem.hasKey(key)) {
						player.sendMessage(PREFIX + ChatColor.RED + "NBT tag \"" + key + "\" is not present on this item");
						return true;
					}
					
					nbtItem.removeKey(key);
					player.getInventory().setItemInMainHand((item = nbtItem.getModifiedItemStack()));
					
					player.sendMessage(PREFIX + ChatColor.GREEN + "NBT tag \"" + key + "\" removed");
				}
				else {
					player.sendMessage(ChatColor.RED + "Missing key value. " + ChatColor.DARK_RED + "/itemnbt remove <key>");
				}
			}
			
			else if (args[0].equalsIgnoreCase("check")) {
				if (args.length >= 2) {
					String key = args[1];
					
					player.sendMessage(PREFIX + (nbtItem.hasKey(key) 
							? ChatColor.GREEN + "NBT tag \"" + key + "\" is present on this item" 
							: ChatColor.RED + "NBT tag \"" + key + "\" is not present on this item"));
				}
				else {
					player.sendMessage(ChatColor.RED + "Missing key value. " + ChatColor.DARK_RED + "/itemnbt check <key>");
				}
			}
			
			else {
				player.sendMessage(PREFIX + "Unknown syntax. " + ChatColor.RED + "/itemnbt <set|remove|check>");
			}
		}
		
		else {
			player.sendMessage(PREFIX + "Unknown syntax. " + ChatColor.RED + "/itemnbt <set|remove|check>");
		}
		return true;
	}
}