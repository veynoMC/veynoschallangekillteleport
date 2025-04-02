package eu.veyno.veynoschallangekillteleport;

import org.bukkit.plugin.java.JavaPlugin;

public final class VeynosChallangeKillTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventManager(), this);

    }

    @Override
    public void onDisable() {
    }
}
