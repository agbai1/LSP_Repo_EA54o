package org.howard.edu.lsp.midterm.question5;

/**
 * Interface that represents a streamable piece of media
 * Ensures all media types implement play, pause, and stop functionalities
 */
public interface Streamable {
    void play();
    void pause();
    void stop();
}
