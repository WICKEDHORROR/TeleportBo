package me.wickedhorror.telebow.commands;

import me.wickedhorror.telebow.TeleBow;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TeleportBowCommand implements CommandExecutor {

    TeleBow  plugin;

    public TeleportBowCommand(TeleBow plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player =  (Player) sender;
            if(player.hasPermission("tpbow.spawnbow")){
                plugin.GivePlayerBow(player);
            }
        }else {
            System.out.println("You Are not a Player.You Can't execute this command");
        }
        return true;
    }
}
