package pl.mefizo.utils;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public final class ChatUtil {
    private ChatUtil() {}

    public static final LegacyComponentSerializer SERIALIZER =
            LegacyComponentSerializer
                    .builder()
                    .hexColors()
                    .extractUrls()
                    .hexCharacter('#')
                    .character('&')
                    .useUnusualXRepeatedCharacterHexFormat()
                    .build();
    public static TextComponent colored(String s) {
        return SERIALIZER.deserialize(s.replace(">>", "»")).decoration(TextDecoration.ITALIC, s.contains("&o"));
    }
}
