package naukajava;	

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable()	{
		Bukkit.getConsoleSender().sendMessage("i'm turning on");
		getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable()	{
		Bukkit.getConsoleSender().sendMessage("i'm turning off");
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDiamond_OreBreak(Diamond_OreBreakEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("Wykopales Cos");
		if(e.getBlock().getType().equals(Material.DIAMOND_ORE))
			Diamond_OreBreakEvent event = new Diamond_OreBreakEvent(e.getPlayer());
			Bukkit.getServer().getPluginManager().callEvent(event);
		}
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDiamond_OreBreak(Diamond_OreBreakEvent e) {	
		Player p = e.getPlayer();
		p.sendMessage("Wykopales rude Diamentu");
	}
}