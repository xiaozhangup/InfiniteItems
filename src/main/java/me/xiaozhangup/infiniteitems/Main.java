package me.xiaozhangup.infiniteitems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info(this + " LOADED...");
        Bukkit.getPluginManager().registerEvents(new EventControl(), this);
    }

}
