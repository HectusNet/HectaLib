package me.marcpg1905.util.var;

public class Time {
    private final long seconds;


    public Time(long seconds) {
        this.seconds = seconds;
    }

    public Time(long time, Format format) {
        seconds = time * format.sec;
    }


    public String getFormatted() {
        return format(seconds);
    }

    public long getAs(Format format) {
        return seconds / format.sec;
    }

    public double getAsExact(Format format) {
        return (double) seconds / format.sec;
    }



    public static String format(long s) {
        String f;

        if (s >= Format.CENT.sec) f = (s / Format.CENT.sec) + Format.CENT.abb;
        else if (s >= Format.DEC.sec) f = (s / Format.DEC.sec) + Format.DEC.abb;
        else if (s >= Format.YR.sec) f = (s / Format.YR.sec) + Format.YR.abb;
        else if (s >= Format.MO.sec) f = (s / Format.MO.sec) + Format.MO.abb;
        else if (s >= Format.WK.sec) f = (s / Format.WK.sec) + Format.WK.abb;
        else if (s >= Format.D.sec) f = (s / Format.D.sec) + Format.D.abb;
        else if (s >= Format.H.sec) f = (s / Format.H.sec) + Format.H.abb;
        else if (s >= Format.MIN.sec) f = (s / Format.MIN.sec) + Format.MIN.abb;
        else f = s + Format.S.abb;

        return f;
    }


    public enum Format {
        S("s", 1),
        MIN("min", 60),
        H("h", 3600),
        D("d", 86_400),
        WK("wk", 604_800),
        MO("mo", 2_629_800),
        YR("yr", 31_557_600),
        DEC("dec", 315_576_000),
        CENT("cent", 3_155_760_000L);

        public final String abb;
        public final long sec;

        Format(String abbreviation, long seconds) {
            abb = abbreviation;
            sec = seconds;
        }
    }
}
