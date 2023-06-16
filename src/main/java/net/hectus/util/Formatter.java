package net.hectus.util;

/**
 * Used to format text.
 * @since 0.0.1-Pre-Alpha
 * @author MarcPG1905
 */
@SuppressWarnings("unused")
public class Formatter {
    /**
     * Convert a {@link String string} in "TEST_STRING" format to pascal case: "Test String".
     *
     * @param in The {@link String string} that should be converted.
     * @return The {@link String string} but formatted to pascal case.
     *         For example, "FORTNITE_FEET" becomes "Fortnite Feet".
     * @since 0.0.1-Pre-Alpha
     */
    public static String toPascalCase(String in) {
        StringBuilder out = new StringBuilder();
        String[] words = in.toLowerCase().split("[_\\- ]");

        for (String word : words) {
            if (out.length() > 0) {
                out.append(" ");
            }

            out.append(Character.toUpperCase(word.charAt(0)));

            if (word.length() > 1) {
                out.append(word.substring(1));
            }
        }

        return out.toString();
    }
}
