package me.peakim.Heroes.Spiderman;

import me.peakim.marveldc.Marveldc;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Mainspiderman implements CommandExecutor {

    //The key is the Player, and the long is the epoch time of the last time they ran the command

    public final HashMap<UUID, Long> cooldown; // male cooldown

    public Mainspiderman() {
        this.cooldown = new HashMap<>();
    } //Male cooldown

    private Marveldc instance = Marveldc.getInstance(); // گرفتن Instance کانفیگ

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        //گرفتن کانفیگ
        int cooldownspiderman = instance.getConfig().getInt("spiderman-cooldown");

        //پایان کانفیگ

        //if the sender is not a player, return false
        if (!(sender instanceof Player)) {
            return false;
        }

        Player bazikon = (Player) sender;

        if (bazikon.hasPermission("spiderman.use")) {

            //if the player is not in the cooldown map, add them to the map and run the code
            //if the player is in the cooldown map, check if the cooldown is over(10 secs)
            if (!cooldown.containsKey(bazikon.getUniqueId()) || System.currentTimeMillis() - cooldown.get(bazikon.getUniqueId()) > cooldownspiderman) {
                cooldown.put(bazikon.getUniqueId(), System.currentTimeMillis());
                bazikon.sendMessage("You threw a cobweb!");

                float yaw = bazikon.getLocation().getYaw(); // get yaw before teleport
                float pitch = bazikon.getLocation().getPitch(); // get pitch before teleport
                // teleport shodan
                Location bazikonlook = bazikon.getTargetBlock(null,30).getLocation().add(0.5,0.5,-.5); //گرفتن بلاکی که بازیکن به آن نگاه میکند
                double x = bazikonlook.getX(); //get x
                double y = bazikonlook.getY(); //get y
                double z = bazikonlook.getZ(); //get z
                bazikon.teleport(new Location(bazikonlook.getWorld(), x,y,z,yaw,pitch)); // teleport
                // Particle hash
                bazikon.getWorld().spawnParticle(Particle.BUBBLE_POP, bazikon.getLocation(), 70);


            } else {

                //if the cooldown is not over, send the player a message
                bazikon.sendMessage(ChatColor.RED + "You should wait for "  + (cooldownspiderman - (System.currentTimeMillis() - cooldown.get(bazikon.getUniqueId()))) + ChatColor.RED + " Miliseconds.");
            }
        }

        else {

            bazikon.sendMessage(ChatColor.RED+"You dont have permission.");

        }
        return true;

    }


}
