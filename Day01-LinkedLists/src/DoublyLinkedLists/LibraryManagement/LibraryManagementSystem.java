package DoublyLinkedLists.LibraryManagement;

import java.util.Scanner;

public class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;
    private int bookCount;

    public LibraryManagementSystem() {
        head = null;
        tail = null;
        bookCount = 0;
    }

    // Add book at the beginning
    public void addBookAtStart(String title, String author, String genre, String bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
        System.out.println("\nBook added at the start: " + title);
    }

    // Add book at the end
    public void addBookAtEnd(String title, String author, String genre, String bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
        System.out.println("\nBook added at the end: " + title);
    }

    // Add book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, String bookID, boolean isAvailable) {
        if (position < 1 || position > bookCount + 1) {
            System.out.println("\nInvalid position!");
            return;
        }

        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (position == 1) {
            addBookAtStart(title, author, genre, bookID, isAvailable);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        newBook.next = temp.next;
        newBook.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newBook;
        }

        temp.next = newBook;

        if (newBook.next == null) {
            tail = newBook;
        }

        bookCount++;
        System.out.println("\nBook added at position " + position);
    }

    // Remove book by Book ID
    public void removeBook(String bookID) {
        if (head == null) {
            System.out.println("\nLibrary is empty!");
            return;
        }

        BookNode temp = head;
        while (temp != null && !temp.getBookID().equals(bookID)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("\nBook not found!");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (temp == tail) {
            tail = temp.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        bookCount--;
        System.out.println("\nBook with ID " + bookID + " removed successfully!");
    }

    // Search book by Title or Author
    public void searchBook(String searchKey) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.getBookTitle().equalsIgnoreCase(searchKey) || temp.getAuthor().equalsIgnoreCase(searchKey)) {
                System.out.println("\nBook Found! Title: " + temp.getBookTitle() + ", Author: " + temp.getAuthor());
                return;
            }
            temp = temp.next;
        }
        System.out.println("\nNo matching book found!");
    }

    // Update Availability Status
    public void updateAvailability(String bookID, boolean newStatus) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.getBookID().equals(bookID)) {
                temp.setAvailabilityStatus(newStatus);
                System.out.println("\nBook ID " + bookID + " availability updated to " + (newStatus ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("\nBook not found!");
    }

    // Display books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("\nLibrary is empty!");
            return;
        }

        System.out.println("\nBooks in library:");
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.getBookTitle() + " by " + temp.getAuthor());
            temp = temp.next;
        }
    }

    // Display books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("\nLibrary is empty!");
            return;
        }

        System.out.println("\nBooks in reverse order:");
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.getBookTitle() + " by " + temp.getAuthor());
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------- Library Management System -------");
            System.out.println("1. Add Book at Start");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title or Author");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books in Reverse Order");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 9) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }

            // Handle choices here...
        }
    }
}
