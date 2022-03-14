package PluginTest555;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager {

    public static boolean handleCommand(CommandSender oSender, Command oCommand, String strLabel, String[] args) {

            if (oSender instanceof Player) {
            Player p = (Player) oSender;
            String Permission = Permissions.checkPerms(p.getName());

                if (oCommand.getName().equalsIgnoreCase("ping")) {
                    oSender.sendMessage("PONG");
                    return true;
                }

                if (oCommand.getName().equalsIgnoreCase("coolteleport")) {
                    if (Permission.equalsIgnoreCase("admin") || Permission.equalsIgnoreCase("lowerclass")) {
                        if (args.length == 3) {
                            if (Permission == "LowerClass"){
                                p.sendMessage(ChatColor.GOLD + "Imma make u wait a bit");
                            }
                            p.teleport(new Location(p.getWorld(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                        } else if (args.length == 1) {
                            Player target = Bukkit.getPlayer(args[0]);
                            p.teleport(target.getLocation());
                            oSender.sendMessage(ChatColor.BLUE + "It worked");
                        } else {
                            p.sendMessage(ChatColor.GREEN + "Hi, " + p.getName() + " Seems to me like you are having trouble, do /help PluginTest555");
                        }
                    } else {
                            p.sendMessage(ChatColor.GREEN + p.getName() + ChatColor.RED + " YOU DO NOT HAVE PERMISSION");
                    }
                    return true;
                }

                if(oCommand.getName().equalsIgnoreCase("givepermission") && args.length == 2){
                    Permissions.addPerson(args[0], args[1]);
                    return true;
                }

            }
        return true;
    }

}
