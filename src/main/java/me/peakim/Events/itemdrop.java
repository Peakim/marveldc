package me.peakim.Events;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class itemdrop implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();
        PlayerInventory inventory = player.getInventory();
        if (player.hasPermission("me.peakim.Heroes.Superman.use") && player.hasPermission("hulk.use")) {

        // حذف آیتم‌های درون اسلات آرمور
        for (ItemStack armorItem : inventory.getArmorContents()) {
            if (armorItem != null && armorItem.getType() != Material.AIR) {
                armorItem.setAmount(0);
            }
        }

    } //Bastan Permission

    }
}
