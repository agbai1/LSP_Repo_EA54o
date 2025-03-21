package org.howard.edu.lsp.midterm.question5;

/**
 * Driver class to test StreamingService
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        
    	// Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test the common behaviors for all media types
        System.out.println("Testing behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test unique behaviors for each media type
        Movie movieWithRewind = (Movie) movie; 
        movieWithRewind.rewind(30);
        System.out.println();

        // Test Audiobook-specific behavior 
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        // Test Music-specific behavior
        Music musicWithPlaylist = (Music) music; 
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}

