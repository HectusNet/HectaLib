package me.marcpg1905.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Randomizer {
    // Get a random boolean based on a chance with numerator and denominator.
    public static boolean boolByChance(int numerator, int denominator) {
        return new Random().nextInt(denominator + 1) < numerator;
    }

    // Get a random boolean based on a chance in percentages.
    public static boolean boolByChance(double percentage) {
        return new Random().nextDouble(101) < percentage;
    }

    // Get a random item from a collection.
    public static Object fromCollection(Collection<?> in) {
        List<Object> objectList = new ArrayList<>(in);
        return objectList.get(new Random().nextInt(objectList.size()));
    }

    // Get a random item from an array.
    public static Object fromArray(Object [] in) {
        return in[new Random().nextInt(in.length)];
    }
}
