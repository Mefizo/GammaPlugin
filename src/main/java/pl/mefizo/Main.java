package pl.mefizo;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import eu.okaeri.configs.yaml.bukkit.serdes.SerdesBukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.mefizo.commands.GammaCommand;
import pl.mefizo.configuration.Configuration;
import pl.mefizo.runnable.ActionBarRunnable;

import java.io.File;
import java.util.logging.Level;

public class Main extends JavaPlugin {
    private Configuration configuration;
    @Override
    public void onEnable() {
        try {
            configuration = ConfigManager.create(Configuration.class, (it) -> {
                it.withConfigurer(new YamlBukkitConfigurer(), new SerdesBukkit());
                it.withBindFile(new File(this.getDataFolder(), "configuration.yml"));
                it.saveDefaults();
                it.load(true);
            });
        } catch (Exception exception) {
            this.getLogger().log(Level.SEVERE, "Error loading configuration files.", exception);
            return;
        }
        registerCommands();
        registerRunnable();
    }

    private void registerRunnable() {
        ActionBarRunnable actionBarRunnable = new ActionBarRunnable(configuration);
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, actionBarRunnable,20,20);
    }

    private void registerCommands() {
        getCommand("gamma").setExecutor(new GammaCommand(configuration));
    }
}