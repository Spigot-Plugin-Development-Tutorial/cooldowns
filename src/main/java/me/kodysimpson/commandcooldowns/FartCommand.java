package me.kodysimpson.commandcooldowns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class FartCommand implements CommandExecutor {

    //The key is the Player, and the long is the epoch time of the last time they ran the command
    private final HashMap<UUID, Long> cooldown;

    public FartCommand() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //if the sender is not a player, return false
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        //if the player is not in the cooldown map, add them to the map and run the code
        //if the player is in the cooldown map, check if the cooldown is over(10 secs)
        if (!cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) > 10000) {
            cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage("You farted! Oopsies!");
        }else{
            //if the cooldown is not over, send the player a message
            player.sendMessage("You can't fart again for another " + (10000 - (System.currentTimeMillis() - cooldown.get(player.getUniqueId()))) + " milliseconds!");
        }

        return true;
    }


}
