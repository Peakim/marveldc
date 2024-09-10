package me.peakim.Heroes.Hulk;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HulkJump implements Listener {

    @EventHandler
    public void OnEvent(PlayerJumpEvent PareshHulk) {



        Player bazikon = (Player) PareshHulk.getPlayer();
        if (bazikon.hasPermission("hulk.use")){
            Player p = bazikon.getPlayer();
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.GREEN, 9.0F);
            bazikon.getWorld().spawnParticle(Particle.REDSTONE, bazikon.getEyeLocation(), 50, dustOptions);






        }



    }



}
