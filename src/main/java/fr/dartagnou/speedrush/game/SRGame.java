package fr.dartagnou.speedrush.game;

import fr.dartagnou.speedrush.SpeedRush;
import fr.dartagnou.speedrush.team.ITeam;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SRGame {

    private SpeedRush plugin;
    private FileConfiguration pluginConfig;

    private String gameTag;

    private Set<SRPlayer> playersInGame;
    private Set<ITeam> teamsInGame;


    public SRGame(String gameTag) {
        this.plugin = SpeedRush.getInstance();
        this.pluginConfig = this.plugin.getSRConfig();

        this.gameTag = gameTag;

        this.playersInGame = new HashSet<>();
        this.teamsInGame = new HashSet<>();
    }




    public SRPlayer getPlayer(UUID uuid) {
        for (SRPlayer player : this.playersInGame)
            if (player.getID().equals(uuid))
                return player;

        return null;
    }

    int taskID = 0;
    public void startCountdown() {

         taskID = this.plugin.scheduleTimer(new BukkitCountdown(this.pluginConfig.getInt("game.time_to_start"), this, game -> {
            this.start();
        }, this.pluginConfig.getString("game.start_message")), 0L, 20L);
    }

    public void start() {
        this.plugin.cancelScheduler(this.taskID);


        for (ITeam team : this.teamsInGame)
            team.getPlayers().forEach(player -> player.getPlayer().teleport(team.getSpawnLocation()));


    }


    public void broadcast(String... messages) {
        this.playersInGame.forEach(player -> player.sendMessage(messages));
    }

    public String getGameTag() {
        return gameTag;
    }
}
