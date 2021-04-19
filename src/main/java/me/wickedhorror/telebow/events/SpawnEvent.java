package me.wickedhorror.telebow.events;

import me.wickedhorror.telebow.TeleBow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class SpawnEvent implements Listener {
    TeleBow plugin;

    public SpawnEvent(TeleBow plugin) {
        this.plugin = plugin;
    }

    @EventHandler

    public void onSpawnEvent(PlayerJoinEvent e){
            Player player = e.getPlayer();
        if(plugin.getConfig().getBoolean("give-bow-on-join")){
            plugin.GivePlayerBow(player);
        }
    }
}
