package net.hectus.data.time;

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
     * @param seconds The {@link Time time} in {@link Unit#SECONDS seconds}.
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
     * @see #oneUnitFormat(long)
     * @since 0.0.1-Pre-Alpha
     */
    public String getOneUnitFormatted() {
        return oneUnitFormat(this);
    }

    /**
     * Get the {@link Time time} as a formatted {@link String string} that is readable.
     * The formatted {@link Time time} uses the highest {@link Unit} possible and then lower ones for remaining time.
     * @return The {@link Time time} as a formatted {@link String string}.
     * @see #preciselyFormat(Time)
     * @since 0.0.1-Pre-Alpha
     */
    public String getPreciselyFormatted() {
        return preciselyFormat(this);
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
     * @param seconds The {@link Time time} in {@link Unit#SECONDS seconds}
     * @since 0.0.2-Pre-Alpha
     */
    public void increment(long seconds) {
        this.seconds += seconds;
    }

    /**
     * Increment the {@link Time time}, useful if used in {@link Timer timers}. <br>
     * This increments the {@link Time time} by 1 {@link Unit#SECONDS second}.
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
     * @param seconds The {@link Time time} in {@link Unit#SECONDS seconds}
     * @since 0.0.2-Pre-Alpha
     */
    public void decrement(long seconds) {
        this.seconds -= seconds;
        if (!allowNegatives && this.seconds < 0) this.seconds = 0;
    }

    /**
     * Decrement the {@link Time time}, useful if used in {@link Timer timers}/countdowns. <br>
     * This decrements the {@link Time time} by 1 {@link Unit#SECONDS second}.
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
     * @param s The time in {@link Unit#SECONDS seconds}.
     * @return The formatted {@link Time time} {@link String string}.
     * @since 0.0.1-Pre-Alpha
     */
    public static String oneUnitFormat(long s) {
        Unit[] units = Unit.values();

        for (int i = units.length; i >= 1; i--) {
            Unit unit = units[i - 1];
            if (s >= unit.sec) return (s / unit.sec) + unit.abb;
        }

        return s + Unit.SECONDS.abb;
    }

    /**
     * Format the {@link Time time} as a {@link String string} representation using the highest possible {@link Unit unit}.
     * @param time The time.
     * @return The formatted {@link Time time} {@link String string}.
     * @since 0.0.4-Pre-Alpha
     */
    public static String oneUnitFormat(Time time) {
        return oneUnitFormat(time.seconds);
    }

    /**
     * Format the {@link Time time} as a {@link String string} representation using the highest possible {@link Unit unit} and then lower ones for remaining time.
     * @param s The time in {@link Unit#SECONDS seconds}.
     * @return The formatted {@link Time time} {@link String string}.
     * @since 0.0.4-Pre-Alpha
     */
    public static String preciselyFormat(long s) {
        Unit[] units = Unit.values();
        StringBuilder result = new StringBuilder();

        for (int i = units.length; i >= 1; i--) {
            Unit unit = units[i - 1];
            if (s >= unit.sec) {
                int quotient = (int) (s / unit.sec);
                s %= unit.sec;

                if (result.length() > 0) result.append(" ");

                result.append(quotient).append(unit.abb);
            }
        }

        if (s > 0) {
            if (result.length() > 0) result.append(" ");
            result.append(s).append("s");
        }

        if (result.length() > 0)
            return result.toString();
        else return "0s";
    }

    /**
     * Format the {@link Time time} as a {@link String string} representation using the highest possible {@link Unit unit} and then lower ones for remaining time.
     * @param time The time.
     * @return The formatted {@link Time time} {@link String string}.
     * @since 0.0.4-Pre-Alpha
     */
    public static String preciselyFormat(Time time) {
        return preciselyFormat(time.seconds);
    }



    /**
     * A time unit, such as {@link Unit#SECONDS seconds}, {@link Unit#MINUTES minutes}, {@link Unit#HOURS hours}, etc.
     * @since 0.0.1-Pre-Alpha
     */
    public enum Unit {
        /** One second - 1000 milliseconds */ SECONDS(1L, "s"),
        /** One minute - 60 seconds */ MINUTES(60L, "min"),
        /** One hour - 60 minutes / 3600 seconds */ HOURS(3600L, "hr"),
        /** One day - 24 hours */ DAYS(86400L, "d"),
        /** One week - 7 days */ WEEKS(604800L, "wk"),
        /** One month - ~4.34 weeks */ MONTHS(2629800L, "mo"),
        /** One year - 12 months / 365.25 days */ YEARS(31557600L, "yr"),
        /** One decade - 10 years */ DECADES(315576000L, "dec"),
        /** One century - 100 years / 10 decades */ CENTURIES(3155760000L, "cent");

        /**
         * The number of {@link #SECONDS seconds} in one {@link Unit unit}. (source: <a href="https://en.wikipedia.org/wiki/Unit_of_time">Wikipedia/Unit of time</a>)
         * @since 0.0.1-Pre-Alpha
         */
        public final long sec;

        /**
         * The {@link Unit unit}'s abbreviation.
         * @since 0.0.4-Pre-Alpha
         */
        public final String abb;

        Unit(long seconds, String abbreviation) {
            sec = seconds;
            abb = abbreviation;
        }

        /**
         * Get {@link #pluralEng()} but as singular. <br>
         * The full english name of the {@link Unit unit} as listed in the english dictionary.
         * @return The english name.
         * @since 0.0.2-Pre-Alpha
         */
        public String eng() {
            return pluralEng().substring(0, this.name().length() - 1).replace("ies", "y");
        }

        /**
         * Get {@link #eng()} but as plural. <br>
         * Most times just with an s, but changes for century = centuries
         * @return Plural form of {@link #eng}
         * @since 0.0.2-Pre-Alpha
         */
        public String pluralEng() {
            return this.name().toLowerCase();
        }

        /**
         * Just the same as {@link #eng()}.
         * @since 0.0.4-Pre-Alpha
         */
        public String toString() {
            return eng();
        }
    }
}
