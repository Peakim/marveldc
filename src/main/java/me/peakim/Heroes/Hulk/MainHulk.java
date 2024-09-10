package me.peakim.Heroes.Hulk;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MainHulk  implements CommandExecutor {




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Head Hulk
        SkullMeta skullhulk = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
        skullhulk.setOwner("Hulk");
        ItemStack headhulk = new ItemStack(Material.PLAYER_HEAD, 1, (byte) 3);
        skullhulk.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        skullhulk.setDisplayName(ChatColor.GREEN + "Hulk Head");
        headhulk.setItemMeta(skullhulk);

        //Sakht Chestplate Hulk
        ItemStack lchesthulk = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lchhulk = (LeatherArmorMeta) lchesthulk.getItemMeta();
        lchhulk.setColor(Color.fromRGB(104, 255, 0));
        lchhulk.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        lchhulk.setDisplayName(ChatColor.GREEN + "Hulk ChestPlate");

        lchesthulk.setItemMeta(lchhulk);
        // Sakht Leggings
        ItemStack lleggingshulk = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lleghulk = (LeatherArmorMeta) lleggingshulk.getItemMeta();
        lleghulk.setColor(Color.fromRGB(104, 255, 0));
        lleghulk.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        lleghulk.setDisplayName(ChatColor.GREEN + "Hulk Leggings");

        lleggingshulk.setItemMeta(lleghulk);
        // Sakht Boots
        ItemStack lbootshulk = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lboohulk = (LeatherArmorMeta) lbootshulk.getItemMeta();
        lboohulk.setColor(Color.fromRGB(104, 255, 0));
        lboohulk.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        lboohulk.setDisplayName(ChatColor.GREEN + "Hulk Boots");

        lbootshulk.setItemMeta(lboohulk);


        if (sender instanceof Player) {

            Player bazikon = (Player) sender;

            if (bazikon.hasPermission("hulk.use")) {


                if (bazikon.isInRain()) {


                    // Age hava baroni bod in karo kon //Effect dadan
                    bazikon.setHealth(20.0);
                    bazikon.sendMessage(ChatColor.GREEN + "You Are Hulk!");
                    bazikon.sendMessage(ChatColor.GREEN + "You have Hulk Jump & Clothes & Damage!");
                    bazikon.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000, 5));
                    bazikon.addPotionEffect((new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000, 3)));
                    bazikon.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000, 250));

                    // bezarim yadam nare chejur item bedam: bazikon.getInventory().addItem(new ItemStack(Material.DIRT,64));

                    bazikon.getEquipment().setHelmet(headhulk);
                    bazikon.getEquipment().setChestplate(lchesthulk);
                    bazikon.getEquipment().setLeggings(lleggingshulk);
                    bazikon.getEquipment().setBoots(lbootshulk);

                    // title baraye chand sanie vaghti hulk shod befrest

                    bazikon.sendTitle(ChatColor.GREEN + "You became the Hulk", ChatColor.DARK_GREEN + "Show your power", 4, 90, 4);

                }
                // Dar gheyr in sorat
                else {
                    //title baraye vaghti nemitune hulk she
                    bazikon.sendMessage(ChatColor.RED + "You are not Hulk!");
                    bazikon.sendMessage(ChatColor.RED + "You should wait for storm weather!");
                    bazikon.sendTitle(ChatColor.RED + "You Cant to be Hulk", ChatColor.DARK_RED + "Sleep for storm", 4, 90, 4);


                    //item haye Armoresh ro set mikone
                    bazikon.getInventory().setHelmet(new ItemStack(Material.AIR));
                    bazikon.getInventory().setChestplate(new ItemStack(Material.AIR));
                    bazikon.getInventory().setLeggings(new ItemStack(Material.AIR));
                    bazikon.getInventory().setBoots(new ItemStack(Material.AIR));
                    //delete kardan effect hash
                    for (PotionEffect pt : bazikon.getActivePotionEffects()) {
                        bazikon.removePotionEffect(pt.getType());
                    }


                }

            }
            else {

                bazikon.sendMessage(ChatColor.RED+"You dont have permission.");

            }
        }

        return true;

    }


}




