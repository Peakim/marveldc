package me.peakim.marveldc;

import me.peakim.Commands.reloadcommand;
import me.peakim.Events.itemdrop;
import me.peakim.Heroes.Spiderman.Mainspiderman;
import me.peakim.Heroes.Superman.Mainsuperman;
import me.peakim.Heroes.Hulk.HulkJump;
import me.peakim.Heroes.Hulk.MainHulk;
import me.peakim.Heroes.IceMan.Icemanjump;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public final class Marveldc extends JavaPlugin {

    public static Marveldc instance; // پیش نیاز کانفیگ
    public static Marveldc getInstance(){
        return instance;

    } //پیش نیاز کانفیگ

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig(); //سیو کردن کانفیگ
        instance = this; // گرفتن instance برای کانفیگ

        // چت های شروع پلاگین
        System.out.println(ChatColor.GREEN  + "[MarvelDC] Plugin is Enabled!");
        System.out.println(ChatColor.GREEN  + "[MarvelDC] This plugin created by Peakim");
        // execute command ha
        getCommand("hulk").setExecutor(new MainHulk());
        getCommand("spiderman").setExecutor(new Mainspiderman());
        getCommand("Marveldc-reload").setExecutor(new reloadcommand());
        // execute event ha
        getServer().getPluginManager().registerEvents(new HulkJump(),this);
        getServer().getPluginManager().registerEvents(new Mainsuperman(),this);
        getServer().getPluginManager().registerEvents(new itemdrop(),this);
        getServer().getPluginManager().registerEvents(new Icemanjump(),this);
    }


    @Override
    public void onDisable() {

        System.out.println(ChatColor.RED  + "[MarvelDC] Your Plugin is Disabled!");
        System.out.println(ChatColor.RED  + "[MarvelDC] This plugin created by Peakim");

        // Plugin shutdown logic
    }
}
