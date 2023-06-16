package net.hectus.time;

/**
 * Time is used to convert and store times with different {@link Unit}s, etc.
 * @since 0.0.1-Pre-Alpha
 * @author MarcPG1905
 */
@SuppressWarnings("unused")
public class Time {
    private long seconds;
    private boolean allowNegatives = false;

    /**
     * Create a {@link Time new Time} object.
     * @param seconds The {@link Time time} in {@link Unit#S seconds}.
     * @since 0.0.1-Pre-Alpha
     */
    public Time(long seconds) {
        this.seconds = seconds;
    }

    /**
     * Create a {@link Time new Time} object.
     * @param time The {@link Time time} value.
     * @param unit The {@link Unit unit} of the {@link Time time} value.
     * @since 0.0.1-Pre-Alpha
     */
    public Time(long time, Unit unit) {
        seconds = time * unit.sec;
    }

    /**
     * Get the {@link Time time} as a formatted {@link String string} that is readable.
     * The formatted {@link Time time} uses the highest {@link Unit} possible for the best readability.
     * @return The {@link Time time} as a formatted {@link String string}.
     * @since 0.0.1-Pre-Alpha
     */
    public String getFormatted() {
        return format(seconds);
    }

    /**
     * Get the {@link Time time} in a specific {@link Unit unit}.
     * @param unit The {@link Unit unit} in which the {@link Time time} should be converted.
     * @return The converted {@link Time time}.
     * @since 0.0.1-Pre-Alpha
     */
    public long getAs(Unit unit) {
        return seconds / unit.sec;
    }

    /**
     * Get the {@link Time time} in a specific {@link Unit unit} as a {@link Double double} for exact precision.
     * @param unit The {@link Unit unit} in which the {@link Time time} should be converted.
     * @return The converted {@link Time time}.
     * @since 0.0.1-Pre-Alpha
     */
    public double getAsExact(Unit unit) {
        return (double) seconds / unit.sec;
    }

    /**
     * Increment the {@link Time time}, useful if used in {@link Timer timers}.
     * @param time The {@link Time time} in the {@link Unit unit} of the second parameter.
     * @param unit The {@link Unit unit} of the {@link Time time}.
     * @since 0.0.2-Pre-Alpha
     */
    public void increment(long time, Unit unit) {
        seconds += time * unit.sec;
    }

    /**
     * Increment the {@link Time time}, useful if used in {@link Timer timers}.
     * @param seconds The {@link Time time} in {@link Unit#S seconds}
     * @since 0.0.2-Pre-Alpha
     */
    public void increment(long seconds) {
        this.seconds += seconds;
    }

    /**
     * Increment the {@link Time time}, useful if used in {@link Timer timers}. <br>
     * This increments the {@link Time time} by 1 {@link Unit#S second}.
     * @since 0.0.2-Pre-Alpha
     */
    public void increment() {
        seconds++;
    }

    /**
     * Decrement the {@link Time time}, useful if used in {@link Timer timers}/countdowns.
     * @param time The {@link Time time} in the {@link Unit unit} of the second parameter.
     * @param unit The {@link Unit unit} of the {@link Time time}.
     * @since 0.0.2-Pre-Alpha
     */
    public void decrement(long time, Unit unit) {
        decrement(time * unit.sec);
    }

    /**
     * Decrement the {@link Time time}, useful if used in {@link Timer timers}/countdowns.
     * @param seconds The {@link Time time} in {@link Unit#S seconds}
     * @since 0.0.2-Pre-Alpha
     */
    public void decrement(long seconds) {
        this.seconds -= seconds;
        if (!allowNegatives && this.seconds < 0) this.seconds = 0;
    }

    /**
     * Decrement the {@link Time time}, useful if used in {@link Timer timers}/countdowns. <br>
     * This decrements the {@link Time time} by 1 {@link Unit#S second}.
     * @since 0.0.2-Pre-Alpha
     */
    public void decrement() {
        this.seconds--;
        if (!allowNegatives && this.seconds < 0) this.seconds = 0;
    }

    /**
     * Make the {@link Time time} allow negative values. <br>
     * CAUTION: THIS CANNOT BE SET TO FALSE AGAIN AFTER BEING SET TO TRUE!
     * @since 0.0.2-Pre-Alpha
     */
    public void allowNegatives() {
        allowNegatives = true;
    }

    /**
     * Format the {@link Time time} as a {@link String string} representation using the highest possible {@link Unit unit}.
     * @param s The time in {@link Unit#S seconds}.
     * @return The formatted {@link Time time} {@link String string}.
     * @since 0.0.1-Pre-Alpha
     */
    public static String format(long s) {
        String formattedTime;

        if (s >= Unit.CENT.sec)
            formattedTime = (s / Unit.CENT.sec) + Unit.CENT.abb;
        else if (s >= Unit.DEC.sec)
            formattedTime = (s / Unit.DEC.sec) + Unit.DEC.abb;
        else if (s >= Unit.YR.sec)
            formattedTime = (s / Unit.YR.sec) + Unit.YR.abb;
        else if (s >= Unit.MO.sec)
            formattedTime = (s / Unit.MO.sec) + Unit.MO.abb;
        else if (s >= Unit.WK.sec)
            formattedTime = (s / Unit.WK.sec) + Unit.WK.abb;
        else if (s >= Unit.D.sec)
            formattedTime = (s / Unit.D.sec) + Unit.D.abb;
        else if (s >= Unit.H.sec)
            formattedTime = (s / Unit.H.sec) + Unit.H.abb;
        else if (s >= Unit.MIN.sec)
            formattedTime = (s / Unit.MIN.sec) + Unit.MIN.abb;
        else formattedTime = s + Unit.S.abb;

        return formattedTime;
    }

    /**
     * A time unit, such as {@link Unit#S seconds}, {@link Unit#MIN minutes}, {@link Unit#H hours}, etc.
     * @since 0.0.1-Pre-Alpha
     */
    public enum Unit {
        S("s", 1, "second"),
        MIN("min", 60, "minute"),
        H("h", 3600, "hour"),
        D("d", 86400, "day"),
        WK("wk", 604800, "week"),
        MO("mo", 2629800, "month"),
        YR("yr", 31557600, "year"),
        DEC("dec", 315576000, "decade"),
        CENT("cent", 3155760000L, "century");

        /**
         * The abbreviation of the {@link Unit unit}. (source: <a href="https://chat.openai.com/">ChatGPT</a>, <a href="https://en.wikipedia.org/wiki/Unit_of_time">Wikipedia/Unit of time</a>)
         * @since 0.0.1-Pre-Alpha
         */
        public final String abb;

        /**
         * The number of {@link #S seconds} in one {@link Unit unit}. (source: <a href="https://en.wikipedia.org/wiki/Unit_of_time">Wikipedia/Unit of time</a>)
         * @since 0.0.1-Pre-Alpha
         */
        public final long sec;

        /**
         * The english word for that {@link Time time} format. (source: <a href="https://en.wikipedia.org/wiki/Unit_of_time">Wikipedia/Unit of time</a>)
         * @since 0.0.2-Pre-Alpha
         */
        public final String eng;

        Unit(String abbreviation, long seconds, String english) {
            abb = abbreviation;
            sec = seconds;
            eng = english;
        }

        /**
         * Get {@link #eng} but as plural. <br>
         * Most times just with an s, but changes for century = centuries
         * @return Plural form of {@link #eng}
         * @since 0.0.2-Pre-Alpha
         */
        public String pluralEng() {
            if (this == CENT) return "centuries";
            else return (eng + "s");
        }
    }
}
