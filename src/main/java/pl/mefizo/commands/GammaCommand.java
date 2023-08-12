package pl.mefizo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import pl.mefizo.configuration.Configuration;
import pl.mefizo.utils.ChatUtil;

public class GammaCommand implements CommandExecutor {

    private final Configuration configuration;
    public GammaCommand(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            player.sendMessage(ChatUtil.colored(configuration.getDisable()));
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            return false;
        } else {
            player.sendMessage(ChatUtil.colored(configuration.getEnable()));
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 2));
        }
        return false;
    }
}
