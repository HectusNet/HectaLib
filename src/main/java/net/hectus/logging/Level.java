package net.hectus.logging;

import net.hectus.color.Ansi;

/**
 * Logging levels
 */
public enum Level {
    /** For keeping track how far the program gets in the code */ TRACE(Ansi.MAGENTA, 10),
    /** For audit logging */ AUDIT(Ansi.GRAY, 9),
    /** Logging statistics */ STATISTIC(Ansi.BRIGHT_BLUE, 8),
    /** Logging configurations, arguments, etc. */ CONFIG(Ansi.BLUE, 7),
    /** For simple logs */ INFO(Ansi.RESET_FG, 6),
    /** Logging things that went fine or were completed */ SUCCESS(Ansi.LIME, 5),
    /** Logging debug things that are only used in the coding process */ DEBUG(Ansi.CYAN, 4),
    /** Warning that something went wrong */ WARNING(Ansi.BROWN, 3),
    /** Warning that something went wrong, which may broke something  */ ERROR(Ansi.DARK_RED, 2),
    /** Warning that something went wrong and broke some component */ SEVERE(Ansi.RED, 1),
    /** Ending the program because something went wrong and broke an important component. */ CRASH(Ansi.fromRGB(255, 0, 127), 0);

    final Ansi color;
    final int priority;

    Level(Ansi color, int prio) {
        this.color = color;
        this.priority = prio;
    }
}
