package me.peakim.marveldc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadcommand implements CommandExecutor {

    private Marveldc instance = Marveldc.getInstance(); // گرفتن Instance کانفیگ
    @Override

    public boolean onCommand(CommandSender sender, Command command, String label,String[] args){

        if (sender instanceof Player){
            if (sender.hasPermission("marveldc.reload")) {
                instance.reloadConfig();
                sender.sendMessage(ChatColor.RED + "[Marvel-dc] Plugin config has been reloaded!");
                return true;

            }
        }



        return true;

    }


}
