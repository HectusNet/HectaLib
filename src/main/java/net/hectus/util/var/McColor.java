package net.hectus.util.var;

import java.awt.*;

/**
 * Minecraft Colors <br>
 * From the <a href="https://minecraft.fandom.com/wiki/Formatting_codes#Usage">Formatting Codes article</a> on the <a href="https://minecraft.fandom.com/wiki">Minecraft Wiki</a>
 */
@SuppressWarnings("unused")
public enum McColor {
    /** Reset the color to the default one */ RESET('r', null, true, true, 0),
    /** Makes the text constantly change */ MAGIC('r', null, true, true, 8),
    /** Bold */ BOLD('r', null, true, true, 1),
    /** Italic */ ITALIC('r', null, true, true, 3),
    /** Strikethrough */ STRIKETHROUGH('r', null, true, false, 9),
    /** Underlined */ UNDERLINED('r', null, true, false, 4),
    /** Dark Red */ DARK_RED('4', "AA0000", true, true, 31),
    /** Light Red */ RED('c', "FF5555", true, true, 91),
    /** Gold / Orange */ GOLD('6', "FFAA00", true, true, 33),
    /** Yellow */ YELLOW('e', "FFFF55", true, true, 93),
    /** Dark Green */ GREEN('2', "00AA00", true, true, 32),
    /** Light Green / Lime */ LIME('a', "55FF55", true, true, 92),
    /** Light Aqua */ AQUA('b', "55FFFF", true, true, 96),
    /** Dark Aqua */ DARK_AQUA('3', "00AAAA", true, true, 36),
    /** Dark Blue */ DARK_BLUE('f', "0000AA", true, true, 34),
    /** Light Blue */ BLUE('9', "5555FF", true, true, 94),
    /** Light Pink */ PINK('d', "FF55FF", true, true, 95),
    /** Purple / Magenta */ PURPLE('5', "AA00AA", true, true, 35),
    /** White */ WHITE('f', "FFFFFF", true, true, 97),
    /** Light Gray */ GRAY('7', "AAAAAA", true, true, 37),
    /** Dark Gray */ DARK_GRAY('8', "555555", true, true, 90),
    /** Black */ BLACK('0', "000000", true, true, 30),
    /** Minecoin Color */ MINECOIN_GOLD('g', "DDD605", false, true, null),
    /** Quartz Color */ MATERIAL_QUARTZ('h', "E3D4D1", false, true, null),
    /** Iron Color */ MATERIAL_IRON('i', "CECACA", false, true, null),
    /** Netherite Color */ MATERIAL_NETHERITE('j', "443A3B", false, true, null),
    /** Redstone Color */ MATERIAL_REDSTONE('m', "971607", false, true, null),
    /** Copper Color */ MATERIAL_COPPER('n', "B4684D", false, true, null),
    /** Gold Color */ MATERIAL_GOLD('p', "DEB12D", false, true, null),
    /** Emerald Color */ MATERIAL_EMERALD('q', "47A036", false, true, null),
    /** Diamond Color */ MATERIAL_DIAMOND('s', "2CBAA8", false, true, null),
    /** Lapislazuli Color */ MATERIAL_LAPIS('t', "21497B", false, true, null),
    /** Amethyst Color */ MATERIAL_AMETHYST('u', "9A5CC6", false, true, null);

    /** The Minecraft color code */
    public final char code;
    /** The color's hexadecimal code */
    public final String hex;
    /** If the color can be used in Minecraft: Java Edition */
    public final boolean java;
    /** If the color can be used in Minecraft: Bedrock Edition */
    public final boolean bedrock;
    /** The ANSI escape code */
    public final Integer ansiCode;

    McColor(char code, String hex, boolean java, boolean bedrock, Integer ansiCode) {
        this.code = code;
        this.hex = hex;
        this.java = java;
        this.bedrock = bedrock;
        this.ansiCode = ansiCode;
    }

    /**
     * Get the color as a Minecraft chat color.
     * Similar to Bukkit/BungeeCord's ChatColor
     * @return § + the code, so you can use it in text.
     */
    public String chatColor() {
        return "§" + code;
    }

    /**
     * Get the color's equivalent Java AWT color.
     * @return Equivalent Java AWT color
     * @see Color
     */
    public Color awtColor() {
        return Color.decode("#" + hex);
    }

    /**
     * Get the color's equivalent ANSI escape code.
     * @return Equivalent ANSI escape code
     */
    public Color ansi() {
        return Color.decode("\\e[0;" + ansiCode + "m");
    }
}
