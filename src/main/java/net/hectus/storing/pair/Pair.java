package net.hectus.storing.pair;

import java.util.logging.Logger;

/**
 * A pair is just two values that have a defined type.
 * It's the same as a {@link java.util.Map}, but with only one value.
 * @param <L> The left field's type
 * @param <R> The right field's type
 * @author MarcPG1905
 * @since 0.0.3-PRE-ALPHA
 */
public class Pair<L,R> {
    private L left;
    private R right;
    private boolean isEmpty;
    private boolean isFull;

    /**
     * Set or change the left field of the pair
     * @param l The new object for the left field
     * @since 0.0.3-PRE-ALPHA
     */
    public void setLeft(L l) {
        left = l;

        if (right != null) isFull = true;
        isEmpty = false;
    }

    /**
     * Get the left field of the pair
     * @return The left field
     * @since 0.0.3-PRE-ALPHA
     */
    public L left() {
        return left;
    }

    /**
     * Set or change the right field of the pair
     * @param r The new object for the right field
     * @since 0.0.3-PRE-ALPHA
     */
    public void setRight(R r) {
        right = r;

        if (left != null) isFull = true;
        isEmpty = false;
    }

    /**
     * Get the right field of the pair
     * @return The right field
     * @since 0.0.3-PRE-ALPHA
     */
    public R right() {
        return right;
    }

    /**
     * Get the field of a specific side from the pair.
     * Not recommend, use {@link #left()} and {@link #right()} instead
     * @param side
     * @return
     */
    public Object get(Side side) {
        if (side == Side.LEFT) return left;
        else return right;
    }

    /**
     * Set or change both fields of the pair
     * @param l The new object for the left field
     * @param r The new object for the right field
     * @since 0.0.3-PRE-ALPHA
     */
    public void set(R r, L l) {
        right = r;
        left = l;
        isFull = true;
        isEmpty = false;
    }

    /**
     * Clear all values. <br>
     * Useful if you wanna somehow use the pair as a {@link java.util.Map}.
     * I have no idea why you would wanna do that, but ye.
     */
    public void clear() {
        right = null;
        left = null;
        isFull = false;
        isEmpty = true;
    }

    public void clear(Side side) {
        if (side == Side.LEFT) {
            left = null;
            if (right == null)
                isEmpty = true;
        } else {
            right = null;
            if (left == null)
                isEmpty = true;
        }
        isFull = false;
    }

    /**
     * Check if the pair is empty.
     * This can also be checked by doing a null-check for the right and left side.
     * @return If the pair is empty
     * @since 0.0.3-PRE-ALPHA
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Check if the pair is full.
     * This can also be checked by doing a null-check for the right and left side.
     * @return If the pair is full
     * @since 0.0.3-PRE-ALPHA
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * This gets the heavier side of the pair based on the memory that the
     * side uses in your random access memory.
     * @return The heavier side of the pair
     * @see #getHeavierObject() The same but it gets the object directly instead of just the side
     * @since 0.0.3-PRE-ALPHA
     */
    public Side getHeavierSide() {
        int ll = String.valueOf(left).length();
        int rl = String.valueOf(right).length();

        if (ll > rl)
            return Side.LEFT;
        else if (rl > ll)
            return Side.RIGHT;
        else
            return null;
    }

    /**
     * This gets the heavier object of the pair based on the memory that the
     * object uses in your random access memory.
     * @return The heavier object of the pair
     * @see #getHeavierSide() The same but it gets the side instead of the object
     * @since 0.0.3-PRE-ALPHA
     */
    public Object getHeavierObject() {
        return get(getHeavierSide());
    }

    /**
     * Convert the Pair to a readable {@link String}. <br>
     * It uses the simple scheme: `{"right":[{@link #right() right field}], "left":[{@link #left() left field}]}`
     * @return The pair in a {@link String} format
     * @since 0.0.3-PRE-ALPHA
     */
    public String toString() {
        String leftString = left.toString();
        if (left instanceof CharSequence) leftString = "\"" + left + "\"";
        if (left instanceof Character) leftString = "'" + left + "'";

        String rightString = left.toString();
        if (left instanceof CharSequence) rightString = "\"" + left + "\"";
        if (left instanceof Character) rightString = "'" + left + "'";

        return "{\"right\":" + rightString + ", \"left\":" + leftString + "}";
    }

    /**
     * A side of a pair
     * @author MarcPG1905
     * @since 0.0.3-PRE-ALPHA
     */
    public enum Side { RIGHT, LEFT }
}
