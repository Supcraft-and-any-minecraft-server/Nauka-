package naukajava;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class Diamond_OreBreakEvent extends Event{
	private static final HandlerList handler = new HandlerList();
	private Player player; 
	public Diamond_OreBreakEvent(Player p) {
		player = p;
	}
	@Override
	public HandlerList getHandlers() {
		return handler;
	}
	public static HandlerList getHandlerList() {
		return handler;
	}		
	public Player getPlayer() {
		return player;
	}	
	
	
}
