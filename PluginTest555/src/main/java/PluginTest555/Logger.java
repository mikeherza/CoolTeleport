package PluginTest555;

import org.bukkit.Bukkit;

import java.util.logging.Level;

public class Logger {
    public static void LogMessage(String LogMessage) {
        Bukkit.getLogger().log(Level.INFO, LogMessage);
    }

    public static void LogWarning(String LogMessage) {
        Bukkit.getLogger().log(Level.WARNING, LogMessage);
    }

    public static void LogSevere(String LogMessage) {
        Bukkit.getLogger().log(Level.SEVERE, LogMessage);
    }

}
