package me.wickedhorror.telebow;

import me.wickedhorror.telebow.commands.TeleportBowCommand;
import me.wickedhorror.telebow.events.SpawnEvent;
import me.wickedhorror.telebow.events.TeleportBowEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class TeleBow extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Plugin startup logic
      getServer().getPluginManager().registerEvents(new TeleportBowEvent(this),this);
      getServer().getPluginManager().registerEvents(new SpawnEvent(this),this);
      getCommand("tpbow").setExecutor(new TeleportBowCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void GivePlayerBow(Player player){
        ItemStack teleport_bow = new ItemStack(Material.BOW);
        teleport_bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 666);
        ItemMeta meta = teleport_bow.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("bow-name")));
        meta.spigot().setUnbreakable(true);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("bow-description")));
        meta.setLore(lore);
        teleport_bow.setItemMeta(meta);

        player.getInventory().addItem(teleport_bow);
    }
}
