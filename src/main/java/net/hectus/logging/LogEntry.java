package net.hectus.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A log entry is just one log, it only exists, so {@link Logger loggers} can save their history.
 */
public class LogEntry {
    /** The log's time */
    public final LocalDateTime time;

    /** The log's level */
    public final Level level;

    /** The log's message */
    public final String message;

    /** The log's logger */
    public final Logger logger;

    /**
     * Creates a new {@link LogEntry}, shouldn't be used without a {@link Logger}.
     * When having a {@link Logger}, the {@link Logger} will automatically do this if you log something.
     * @param level The {@link Level} of the log
     * @param message The log's message
     * @param logger What {@link Logger} the log belongs to
     */
    public LogEntry(Level level, String message, Logger logger) {
        this.time = LocalDateTime.now();
        this.level = level;
        this.message = message;
        this.logger = logger;
    }

    /**
     * Print the log to the console
     */
    public void print() {
        String time = this.time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss "));
        System.out.println(level.color + time + "[" + logger.getName() + "] [" + level.name() + "] " + message);
    }
}
