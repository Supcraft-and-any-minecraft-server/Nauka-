package naukajava;	

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.config.yaml.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	private static final Location Location = null;

	public void onEnable()	{
		Bukkit.getConsoleSender().sendMessage("i'm turning on");
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().addDefault("Wlascicel", "Delordeq");
		getConfig().addDefault("Whitelist", true);
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getConfig().set("Max Graczy", 500);
		saveConfig();
		reloadConfig();
		String[] list = {"a", "b", "testjava"};
		getConfig().set("lista", list);
		List<String> list2 = getConfig().getStringList("Lista");
	}
	public void onDisable()	{
		Bukkit.getConsoleSender().sendMessage("i'm turning off");
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDiamond_OreBreak(Diamond_OreBreakEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("Wykopales Cos");
		if(e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
			Diamond_OreBreakEvent event = new Diamond_OreBreakEvent(e.getPlayer());
			Bukkit.getServer().getPluginManager().callEvent(event);
		
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDiamond_OreBreak(Diamond_OreBreakEvent e) {	
		Player p = e.getPlayer();
		Location l = new Location(Bukkit.getWorld("World"), 0, 70, 0));
		p.teleport(l);
		p.sendMessage("Wykopales rude Diamentu");
		File f = new File ("Plugins/naukajava/statystyki.yml");
		YamlConfiguration yamlFile = YamlConfiguration.LoadConfiguration(f);
		if()yamlFile).getInt(p.getName()+".diamond_ore")==null) yamlFile.set(p.getName()+".diamond_ore", 0);
		yamlFile.set(p.getName()+".diamond_ore", yamlFile.getInt(p.getName()+".diamond_ore")+1);
		try {
			yamlFile.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("break")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
				
				return true;
			}else {
				sender.sendMessage("Break 2");
				return true;
			}
		}
		return false;
	}
	
	@EventHandler 
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		String[] cmd = e.getMessage().split(" ");
		if(cmd[0].equalsIgnoreCase("Witaj")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("siema");
		}
	}
	
	
}
