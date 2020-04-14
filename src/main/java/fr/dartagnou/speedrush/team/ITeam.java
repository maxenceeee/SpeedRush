package fr.dartagnou.speedrush.team;

import fr.dartagnou.speedrush.game.SRPlayer;
import org.bukkit.DyeColor;
import org.bukkit.Location;

import java.util.Set;

public interface ITeam {

    String getDisplayName();

    String getID();

    DyeColor getBlockColor();

    Set<SRPlayer> getPlayers();

    Location getSpawnLocation();

    Location getFlagLocation();
}
