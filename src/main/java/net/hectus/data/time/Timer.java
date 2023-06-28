package net.hectus.data.time;

/**
 * A template for a custom timer
 * @since 0.0.2-Pre-Alpha
 * @author MarcPG1905
 */
@SuppressWarnings("unused")
public interface Timer {
    /**
     * Starts the timer
     * @since 0.0.2-Pre-Alpha
     */
    void start();

    /**
     * Stops the timer, cannot be started again after that.
     * @since 0.0.2-Pre-Alpha
     */
    void stop();

    /**
     * Get the time that's left before the timer finishes.
     * @return The time that's left
     * @since 0.0.2-Pre-Alpha
     */
    Time getLeft();

    /**
     * Get the time that the timer already ran for.
     * @return The time that's done
     * @since 0.0.2-Pre-Alpha
     */
    Time getDone();

    /**
     * Pauses the timer, can be resumed afterward.
     * Just {@link #stop()} but it isn't stopped completely.
     * @return true = The timer got paused.
     *         false = The timer was already paused, so nothing changed.
     * @since 0.0.2-Pre-Alpha
     */
    default boolean pause() {
        return false;
    }

    /**
     * Resumes the timer after it got paused.
     * @return true = The timer got resumed.
     *         false = The timer wasn't paused, so nothing changed.
     * @since 0.0.5-Pre-Alpha
     */
    default boolean resume() {
        return false;
    }
}
