package me.peakim.Heroes.IceMan;

import me.peakim.marveldc.Marveldc;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Icemanjump implements Listener {


    private Marveldc instance = Marveldc.getInstance(); // گرفتن Instance کانفیگ

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        //Config
        int distance_iceman = instance.getConfig().getInt("Iceman-icedistance");
        //Config

        if (event.getPlayer().hasPermission("Iceman.use")) {
            Block block = event.getPlayer().getLocation().getBlock();

            for (int x = -distance_iceman; x <= distance_iceman; x++) {
                for (int z = -distance_iceman; z <= distance_iceman; z++) {
                    Block currentBlock = block.getRelative(x, -1, z);

                    if (currentBlock.getType() == Material.WATER) {
                        currentBlock.setType(Material.ICE);
                    }
                }
            }
        }
    }
}
