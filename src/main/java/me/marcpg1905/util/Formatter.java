package me.marcpg1905.util;

public class Formatter {
    // Format a sentence or set value(ALL_UPPERCASE_WITH_UNDERSCORES) to use a capitalized letter as the first letter of any word.
    public static String toPascalCase(String in) {

        StringBuilder out = new StringBuilder();
        String[] words = in.toLowerCase().split("_");

        for (String word : words) {
            if (out.length() > 0) out.append(" ");

            out.append(Character.toUpperCase(word.charAt(0)));

            if (word.length() > 1) out.append(word.substring(1));
        }

        return out.toString();
    }
}
