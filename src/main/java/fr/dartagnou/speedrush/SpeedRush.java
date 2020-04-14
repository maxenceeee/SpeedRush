package fr.dartagnou.speedrush;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SpeedRush extends JavaPlugin {

    private static SpeedRush instance;

    private FileConfiguration srConfig;


    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.srConfig = this.getConfig();
    }

    public FileConfiguration getSRConfig() {
        return this.srConfig;
    }

    public int scheduleTimer(Runnable runnable, long startIn, long period) {
        return Bukkit.getScheduler().runTaskTimer(this, runnable, startIn, period).getTaskId();
    }

    public void cancelScheduler(int taskID) {
        Bukkit.getScheduler().cancelTask(taskID);
    }

    public static SpeedRush getInstance() {
        return instance;
    }
}
