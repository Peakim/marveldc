package me.peakim.Heroes.Superman;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Mainsuperman implements Listener {

    @EventHandler
    public void onEvent(PlayerToggleSneakEvent Superman) {

        SkullMeta skullsuper = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
        skullsuper.setOwner("superman");
        ItemStack headsuperman = new ItemStack(Material.PLAYER_HEAD,1, (byte)3);
        skullsuper.addEnchant(Enchantment.BINDING_CURSE,1,true);
        skullsuper.setDisplayName(ChatColor.RED + "SuperMan Head");
        headsuperman.setItemMeta(skullsuper);

        //Sakht Chestplate SuperMan
        ItemStack lchestsuperman = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lchestsuper = (LeatherArmorMeta)lchestsuperman.getItemMeta();
        lchestsuper.setColor(Color.fromRGB(255, 41, 41));
        lchestsuper.addEnchant(Enchantment.BINDING_CURSE,1,true);
        lchestsuper.setDisplayName(ChatColor.RED + "SuperMan ChestPlate");

        lchestsuperman.setItemMeta(lchestsuper);

        // Sakht Leggings
        ItemStack llegingsuperman = new ItemStack(Material.LEATHER_LEGGINGS,1);
        LeatherArmorMeta llegingsuper = (LeatherArmorMeta) llegingsuperman.getItemMeta();
        llegingsuper.setColor(Color.fromRGB(255,41,41));
        llegingsuper.addEnchant(Enchantment.BINDING_CURSE,1,true);
        llegingsuper.setDisplayName(ChatColor.RED + "SuperMan Leggings");

        llegingsuperman.setItemMeta(llegingsuper);

        // Sakht Boots
        ItemStack lbootsuperman = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta lboosuperman = (LeatherArmorMeta)  lbootsuperman.getItemMeta();
        lboosuperman.setColor(Color.fromRGB(255,41,41));
        lboosuperman.addEnchant(Enchantment.BINDING_CURSE,1,true);
        lboosuperman.setDisplayName(ChatColor.RED + "SuperMan Boots");
        lbootsuperman.setItemMeta(lboosuperman);


        Player bazikon = (Player) Superman.getPlayer();



        if (bazikon.hasPermission("me.peakim.Heroes.Superman.use")) {
            // Add kardan effect vaghti shift migire
            if (!bazikon.isSneaking()) {
                bazikon.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 50000, 10));
                bazikon.getEquipment().setHelmet(headsuperman);
                bazikon.getEquipment().setChestplate(lchestsuperman);
                bazikon.getEquipment().setLeggings(llegingsuperman);
                bazikon.getEquipment().setBoots(lbootsuperman);
                //// Particle
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 2.0F);

                bazikon.getWorld().spawnParticle(Particle.REDSTONE, bazikon.getEyeLocation(), 50, dustOptions);
            }
            else {

                for (PotionEffect pt : bazikon.getActivePotionEffects()) {

                    //// Particle repeat

                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 2.0F);

                    bazikon.spawnParticle(Particle.REDSTONE, bazikon.getEyeLocation(), 50, dustOptions);

                    bazikon.removePotionEffect(pt.getType());

                }
            }
        }
    }
}
