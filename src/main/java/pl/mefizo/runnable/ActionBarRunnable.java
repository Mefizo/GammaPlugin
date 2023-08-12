package pl.mefizo.runnable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import pl.mefizo.configuration.Configuration;
import pl.mefizo.utils.ChatUtil;

public class ActionBarRunnable implements Runnable {

    private final Configuration configuration;
    public ActionBarRunnable(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers().stream().filter(player -> player.hasPotionEffect(PotionEffectType.NIGHT_VISION)).toList()) {
            player.sendActionBar(ChatUtil.colored(configuration.getActionbar()));
        }
    }
}