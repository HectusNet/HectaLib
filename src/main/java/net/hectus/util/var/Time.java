package net.hectus.util.var;

/**
 * Time is used to convert and store times with different units, etc.
 * @since 0.0.1-Pre-Alpha
 */
@SuppressWarnings("unused")
public class Time {
    private final long seconds;

    /**
     * Create a new Time object.
     * @param seconds The time in seconds.
     * @since 0.0.1-Pre-Alpha
     */
    public Time(long seconds) {
        this.seconds = seconds;
    }

    /**
     * Create a new Time object.
     * @param time The time value.
     * @param unit The unit of the time value.
     * @since 0.0.1-Pre-Alpha
     */
    public Time(long time, Unit unit) {
        seconds = time * unit.sec;
    }

    /**
     * Get the time as a formatted string that is readable.
     * The formatted time uses the highest unit possible for the best readability.
     * @return The time as a formatted string.
     * @since 0.0.1-Pre-Alpha
     */
    public String getFormatted() {
        return format(seconds);
    }

    /**
     * Get the time in a specific unit.
     * @param unit The unit in which the time should be converted.
     * @return The converted time.
     * @since 0.0.1-Pre-Alpha
     */
    public long getAs(Unit unit) {
        return seconds / unit.sec;
    }

    /**
     * Get the time in a specific unit as a double for exact precision.
     * @param unit The unit in which the time should be converted.
     * @return The converted time.
     * @since 0.0.1-Pre-Alpha
     */
    public double getAsExact(Unit unit) {
        return (double) seconds / unit.sec;
    }

    /**
     * Format the time as a string representation using the highest possible unit.
     * @param s The time in seconds.
     * @return The formatted time string.
     * @since 0.0.1-Pre-Alpha
     */
    public static String format(long s) {
        String formattedTime;

        if (s >= Unit.CENT.sec) {
            formattedTime = (s / Unit.CENT.sec) + Unit.CENT.abb;
        } else if (s >= Unit.DEC.sec) {
            formattedTime = (s / Unit.DEC.sec) + Unit.DEC.abb;
        } else if (s >= Unit.YR.sec) {
            formattedTime = (s / Unit.YR.sec) + Unit.YR.abb;
        } else if (s >= Unit.MO.sec) {
            formattedTime = (s / Unit.MO.sec) + Unit.MO.abb;
        } else if (s >= Unit.WK.sec) {
            formattedTime = (s / Unit.WK.sec) + Unit.WK.abb;
        } else if (s >= Unit.D.sec) {
            formattedTime = (s / Unit.D.sec) + Unit.D.abb;
        } else if (s >= Unit.H.sec) {
            formattedTime = (s / Unit.H.sec) + Unit.H.abb;
        } else if (s >= Unit.MIN.sec) {
            formattedTime = (s / Unit.MIN.sec) + Unit.MIN.abb;
        } else {
            formattedTime = s + Unit.S.abb;
        }

        return formattedTime;
    }

    /**
     * A time unit, such as seconds, minutes, hours, etc.
     * @since 0.0.1-Pre-Alpha
     */
    public enum Unit {
        S("s", 1),
        MIN("min", 60),
        H("h", 3600),
        D("d", 86400),
        WK("wk", 604800),
        MO("mo", 2629800),
        YR("yr", 31557600),
        DEC("dec", 315576000),
        CENT("cent", 3155760000L);

        /**
         * The abbreviation of the time unit.
         * @since 0.0.1-Pre-Alpha
         */
        public final String abb;

        /**
         * The number of seconds in one time unit.
         * @since 0.0.1-Pre-Alpha
         */
        public final long sec;

        Unit(String abbreviation, long seconds) {
            abb = abbreviation;
            sec = seconds;
        }
    }
}
