package fr.dartagnou.speedrush.game;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SRPlayer {

    private final Player player;


    public SRPlayer(Player player) {
        this.player = player;
    }

    public String getDisplayName() {
        OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(this.player.getUniqueId());

        if (!offPlayer.isOnline())
            return offPlayer.getName();

        return offPlayer.getPlayer().getDisplayName();
    }

    public void sendMessage(String... messages) {
        OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(this.player.getUniqueId());

        if (offPlayer == null || !offPlayer.isOnline())
            return;

        ((Player) offPlayer).sendMessage(messages);
    }

    public Player getPlayer() {
        return player;
    }

    public UUID getID() {
        return this.player.getUniqueId();
    }


}
