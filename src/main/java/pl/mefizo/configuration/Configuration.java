package pl.mefizo.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;

public class Configuration extends OkaeriConfig {
    @Comment("on message")
    private String enable = "&aWlaczyles gamme";
    @Comment("off message")
    private String disable = "&cWylaczyles gamme";
    @Comment("actionbar")
    private String actionbar = "&aPosiadasz wlaczona gamme!";

    public String getEnable() {
        return enable;
    }

    public String getDisable() {
        return disable;
    }

    public String getActionbar() {
        return actionbar;
    }
}
