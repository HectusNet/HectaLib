package net.hectus.data.time;

/**
 * @since 0.0.2-Pre-Alpha
 * @author MarcPG1905
 */
@SuppressWarnings("unused")
public interface Timer {
    void start();
    void stop();
    Time getLeft();
    Time getDone();
    default void pause() {}
}
