package PluginTest555;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {

	public static JavaPlugin oPlugin = null;

	@Override
	public void onEnable(){
		Logger.LogMessage("Starting...");
		Logger.LogSevere("This is an error");
		Logger.LogWarning("This is a warning");
		oPlugin = this;
		Logger.LogMessage("Startup done...");
	}

	@Override
	public void onDisable(){
		Logger.LogMessage("shutting...");
		oPlugin = null;
		Logger.LogMessage("shutdown done");
	}

	@Override
	public boolean onCommand(CommandSender oSender, Command oCommand, String strLabel, String[] args){
		return CommandManager.handleCommand(oSender, oCommand, strLabel, args);
	}
}
