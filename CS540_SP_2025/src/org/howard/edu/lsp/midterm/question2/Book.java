package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library with title, author, ISBN, and publication year
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructor for creating a Book object
     * 
     * @param title         The title of the book
     * @param author        The author of the book
     * @param ISBN          The unique ISBN identifier of the book
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Checks if two Book objects are equal based on ISBN and author
     * 
     * @param obj The object to compare
     * @return True if the books have the same ISBN and author, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
    }

    /**
     * Returns a string representation of the book
     * 
     * @return A formatted string describing the book
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
