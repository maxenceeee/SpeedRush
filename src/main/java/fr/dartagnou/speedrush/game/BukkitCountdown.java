package fr.dartagnou.speedrush.game;

import org.bukkit.ChatColor;

import java.util.function.Consumer;

public class BukkitCountdown implements Runnable {

    private int time;
    private int maxTime;

    private SRGame game;
    private Consumer<SRGame> callBack;

    private String message;


    public BukkitCountdown(int maxTime, SRGame game, Consumer<SRGame> callBack, String message) {
        this.time = 0;
        this.maxTime = maxTime;

        this.game = game;
        this.callBack = callBack;

        this.message = message;
    }

    @Override
    public void run() {
        this.time++;

        if (this.time >= this.maxTime)
            this.callBack.accept(this.game);

        int timeRemaining = (this.maxTime - this.time);

        if  (!(timeRemaining >= 10 || (this.time % 10) == 0))
            return;


        ChatColor messageColor = timeRemaining == 1 ? ChatColor.RED : timeRemaining == 2 ? ChatColor.GOLD : timeRemaining == 3 ? ChatColor.YELLOW : ChatColor.AQUA;
        this.game.broadcast(this.game.getGameTag() + " " + messageColor + this.message.replace("%time%", "" + this.time));

    }
}
