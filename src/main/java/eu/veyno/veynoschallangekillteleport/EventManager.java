package eu.veyno.veynoschallangekillteleport;

import eu.veyno.veynosChallangeCore.api.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EventManager implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if(!Core.isChallengeActive()||e instanceof PlayerTeleportEvent) return;
        if(e.getTo().getX()!=e.getPlayer().getLocation().getX()||e.getTo().getZ()!=e.getPlayer().getLocation().getZ()) e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){
        if(e.getDamageSource().getCausingEntity() instanceof Player && Core.isChallengeActive()){
            Player p = (Player)e.getDamageSource().getCausingEntity();
            p.teleport(e.getEntity());
        }
    }

}
