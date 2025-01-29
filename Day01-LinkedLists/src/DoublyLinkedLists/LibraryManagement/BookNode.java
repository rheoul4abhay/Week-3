package DoublyLinkedLists.LibraryManagement;

public class BookNode {
    private String bookTitle;
    private String author;
    private String genre;
    private String bookID;
    private boolean isAvailable;

    BookNode next;
    BookNode prev;

    public BookNode(String bookTitle, String author, String genre, String bookID, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    // Getters
    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getBookID() {
        return bookID;
    }

    public boolean getAvailabilityStatus() {
        return isAvailable;
    }

    // Setters
    public void setBookTitle(String newTitle) {
        bookTitle = newTitle;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public void setGenre(String newGenre) {
        genre = newGenre;
    }

    public void setBookID(String newBookID) {
        bookID = newBookID;
    }

    public void setAvailabilityStatus(boolean newStatus) {
        isAvailable = newStatus;
    }
}
