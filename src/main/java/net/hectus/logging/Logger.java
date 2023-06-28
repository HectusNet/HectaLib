package net.hectus.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logger {
    private final String name;
    private final List<LogEntry> logHistory = new ArrayList<>();
    private final long id;

    /**
     * Creates a {@link Logger new Logger} with a custom name
     * @param name The {@link Logger}'s name
     */
    public Logger(String name) {
        this.name = name;
        id = new Random().nextLong();
    }

    /**
     * Get the logger's name
     * @return The logger's name
     */
    public String getName() {
        return name;
    }

    /**
     * Log something
     * @param lvl The log's level
     * @param msg The log's message/content
     */
    public void log(Level lvl, String msg) {
        LogEntry entry = new LogEntry(lvl, msg, this);
        entry.print();
        logHistory.add(entry);

        if (lvl == Level.CRASH) System.exit(-1);
    }

    /**
     * Get all logs that every happened in this logger as an ordered {@link List} with all {@link LogEntry LogEntries}
     * @return The full log history
     */
    public List<LogEntry> getLogHistory() {
        return logHistory;
    }

    public void trace(String point) {
        log(Level.TRACE, point);
    }
    public void auditLog(String entry) {
        log(Level.AUDIT, entry);
    }
    public void stat(String statistic, Object value) {
        log(Level.STATISTIC, statistic + " : " + value.toString());
    }
    public void config(String key, Object value){
        log(Level.CONFIG, key + " : " + value.toString());
    }
    public void config(String msg) {
        log(Level.CONFIG, msg);
    }
    public void info(String msg) {
        log(Level.INFO, msg);
    }
    public void success(String msg) {
        log(Level.SUCCESS, msg);
    }
    public void debug(String msg) {
        log(Level.DEBUG, msg);
    }
    public void warning(String msg) {
        log(Level.WARNING, msg);
    }
    public void error(String msg) {
        log(Level.ERROR, msg);
    }
    public void severe(String msg) {
        log(Level.SEVERE, msg);
    }
    public void crash(String msg) {
        log(Level.CRASH, msg);
    }
}
