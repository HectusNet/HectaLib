package net.hectus.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Used to get random values from things
 * @since 0.0.1-Pre-Alpha
 */
@SuppressWarnings("unused")
public class Randomizer {
    /**
     * All basic characters that are on a keyboard and supported in most fonts and formats.
     * @since 0.0.1-Pre-Alpha
     */
    public static final String BASIC_CHARS = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    /**
     * Returns a random boolean value based on a fraction represented by the numerator and denominator.
     * The numerator represents the desired outcomes, while the denominator represents the total possibilities.
     *
     * @param numerator   The number of desired outcomes.
     * @param denominator The total number of possibilities.
     * @return Returns true or false randomly based on the fraction represented by the numerator and denominator.
     * @since 0.0.1-Pre-Alpha
     */
    public static boolean boolByChance(int numerator, int denominator) {
        return new Random().nextInt(denominator + 1) < numerator;
    }

    /**
     * Returns a random boolean value based on a percentage.
     * A 1% chance would almost always return false.
     * A 99% chance would almost always return true.
     *
     * @param percentage The chance in percentage (0-100%) to return true.
     * @return Returns true or false randomly based on the input percentage.
     * @since 0.0.1-Pre-Alpha
     */
    public static boolean boolByChance(double percentage) {
        return new Random().nextDouble() < percentage / 100;
    }

    /**
     * Returns a random object from the given collection.
     *
     * @param in The collection from which a random object should be selected.
     * @return A random object from the input collection.
     * @since 0.0.1-Pre-Alpha
     */
    public static Object fromCollection(Collection<?> in) {
        List<Object> objectList = new ArrayList<>(in);
        return objectList.get(new Random().nextInt(objectList.size()));
    }

    /**
     * Returns a random object from the given array.
     *
     * @param in The array from which a random object should be selected.
     * @return A random object from the input array.
     * @since 0.0.1-Pre-Alpha
     */
    public static Object fromArray(Object[] in) {
        return in[new Random().nextInt(in.length)];
    }

    /**
     * Generates a random String based on available characters and a length.
     * @param length The length of the randomly generated String
     * @param charset What characters can be used in the randomly generated String
     * @return A randomly generated String
     * @since 0.0.1-Pre-Alpha
     */
    public static String generateRandomString(int length, String charset) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(charset.length());
            char randomChar = charset.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    /**
     * Generates a random String based on basic characters and a length.
     * @param length The length of the randomly generated String
     * @return A randomly generated String
     * @since 0.0.1-Pre-Alpha
     */
    public static String generateRandomString(int length) {
        return generateRandomString(length, BASIC_CHARS);
    }

    /**
     * Picks a random character out of a String
     * @param charset All available characters, can have one char multiple times.
     * @return A random character
     * @since 0.0.1-Pre-Alpha
     */
    public static char randomChar(String charset) {
        int randomIndex = new Random().nextInt(charset.length());
        return charset.charAt(randomIndex);
    }

    /**
     * Picks a random character out of basic characters
     * @return A random character
     * @since 0.0.1-Pre-Alpha
     */
    public static char randomChar() {
        return randomChar(BASIC_CHARS);
    }
}
