package net.hectus.text;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @since 0.0.2-Pre-Alpha
 * @author MarcPG1905
 */
@SuppressWarnings("unused")
public class Completer {
    /**
     * Filter suggestions based on what was already typed. <br>
     * If suggested has "max", "cat", "thomas" and "mouse" in it, <br>
     * input = "c" would suggest "<b>c</b>at" <br>
     * input = "m" would suggest "<b>m</b>ouse" and "<b>m</b>ax"
     * @param input What was already typed
     * @param suggested All things that can be suggested
     * @return A {@link List list} of filtered suggestions based on input and suggested
     * @see #startComplete(String, String[])
     * @since 0.0.2-Pre-Alpha
     */
    public static List<String> startComplete(String input, Collection<String> suggested) {
        return suggested.stream()
                .filter(option -> option.toLowerCase().startsWith(input.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Filter suggestions based on what was already typed. <br>
     * If suggested has "max", "cat", "thomas" and "mouse" in it, <br>
     * input = "c" would suggest "cat" <br>
     * input = "m" would suggest "mouse" and "max"
     * @param input What was already typed
     * @param suggested All things that can be suggested
     * @return A {@link List list} of filtered suggestions based on input and suggested
     * @see #startComplete(String, Collection)
     * @since 0.0.2-Pre-Alpha
     */
    public static List<String> startComplete(String input, String[] suggested) {
        return Arrays.stream(suggested)
                .filter(option -> option.toLowerCase().startsWith(input.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Filter suggestions based on what was already typed. <br>
     * If suggested has "max", "cat", "thomas" and "mouse" in it, <br>
     * input = "c" would suggest "<b>c</b>at" <br>
     * input = "m" would suggest "<b>m</b>ouse", "<b>m</b>ax" and "tho<b>m</b>as"
     * @param input What was already typed
     * @param suggested All things that can be suggested
     * @return A {@link List list} of filtered suggestions based on input and suggested
     * @see #containComplete(String, String[])
     * @since 0.0.2-Pre-Alpha
     */
    public static List<String> containComplete(String input, Collection<String> suggested) {
        return suggested.stream()
                .filter(option -> option.toLowerCase().contains(input.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Filter suggestions based on what was already typed. <br>
     * If suggested has "max", "cat", "thomas" and "mouse" in it, <br>
     * input = "c" would suggest "<b>c</b>at" <br>
     * input = "m" would suggest "<b>m</b>ouse", "<b>m</b>ax" and "tho<b>m</b>as"
     * @param input What was already typed
     * @param suggested All things that can be suggested
     * @return A {@link List list} of filtered suggestions based on input and suggested
     * @see #containComplete(String, Collection)
     * @since 0.0.2-Pre-Alpha
     */
    public static List<String> containComplete(String input, String[] suggested) {
        return Arrays.stream(suggested)
                .filter(option -> option.toLowerCase().contains(input.toLowerCase()))
                .collect(Collectors.toList());
    }
}
