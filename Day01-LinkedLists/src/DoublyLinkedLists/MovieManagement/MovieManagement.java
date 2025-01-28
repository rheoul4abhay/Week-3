package DoublyLinkedLists.MovieManagement;

import java.util.Scanner;
public class MovieManagement {

    private MovieNode head;

    //To add a new movie to the start of the record
    public void addAtStart(String title, String director, int yearOfRelease, String rating){
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if(head == null){
            head = newMovie;
            System.out.print("\nMovie with title " + newMovie.getTitle() + " added to beginning of records successfully!");
            System.out.println();
            return;
        }
        head.prev = newMovie;
        newMovie.next = head;
        head = newMovie;
        System.out.print("\nMovie with title " + newMovie.getTitle() + " added at the beginning of records successfully!");
        return;
    }

    //To add a new movie at the end of the record
    public void addAtEnd(String title, String director, int yearOfRelease, String rating){
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if(head == null){
            head = newMovie;
            System.out.print("\nMovie with title " + newMovie.getTitle() + " added at the end of records successfully!");
            System.out.println();
            return;
        }

        //Traverse all the way to the end node
        MovieNode currentMovieNode = head;
        while(currentMovieNode.next != null){
            currentMovieNode = currentMovieNode.next;
        }

        currentMovieNode.next = newMovie;
        newMovie.prev = currentMovieNode;
        System.out.println("\nMovie with title " + newMovie.getTitle() + " added at the end of records successfully!");
        return;
    }

    //To add new movie record any specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, String rating){
        if(position < 1){
            System.out.print("\nPosition should be >= 1!");
            return;
        }

        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if(position == 1){
            newMovie.next = head;
            if(head != null){
                head.prev = newMovie;
            }
            head = newMovie;
            System.out.print("\nMovie with title " + newMovie.getTitle() + " added at the position " + position + " successfully!");
            return;
        }

        //Now we try to reach the node just before the position where new node is to be added
        MovieNode currentMovieNode = head;
        int count = 1;
        while(currentMovieNode != null && count < position - 1){
            currentMovieNode = currentMovieNode.next;
            count++;
        }

        if(currentMovieNode == null){
            System.out.print("\nPosition out of bounds!");
            return;
        } else {
            newMovie.next = currentMovieNode.next;
            if(currentMovieNode.next != null){
                currentMovieNode.next.prev = newMovie;
            }
            currentMovieNode.next = newMovie;
            newMovie.prev = currentMovieNode;

            System.out.print("\nMovie with title " + newMovie.getTitle() + " added at position " + position + " successfully!");
            return;
        }
    }

    //To remove a movie record by movie title
    public void deleteRecord(String title) {
        if (head == null) {
            System.out.print("\nMovie record list is empty! Add some records first!");
            return;
        }

        if (head.getTitle().equals(title)) {
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
            System.out.print("\nMovie record with title " + title + " deleted successfully!");
            return;
        }

        MovieNode currentMovie = head;
        while (currentMovie != null) {
            if (currentMovie.getTitle().equals(title)) {
                if(currentMovie.next != null){
                    currentMovie.next.prev = currentMovie.prev;
                }
                if(currentMovie.prev != null){
                    currentMovie.prev.next = currentMovie.next;
                }
                System.out.print("\nMovie record with title " + title + " deleted from records successfully!");
                return;
            }
            currentMovie = currentMovie.next;
        }
        System.out.print("\nNo movie record with title " + title + " found in records!");
        return;
    }

    //To search for a record by their director name or rating
    public void searchRecord(String searchKey){
        if(head == null){
            System.out.print("\nList is empty! Add some records first!");
            return;
        }

        MovieNode currentMovie = head;
        while(currentMovie != null){
            if(currentMovie.getDirector().equals(searchKey) || currentMovie.getRating().equals(searchKey)){
                System.out.print("\nRecord found! Movie Title : " + currentMovie.getTitle() + ", Director : " + currentMovie.getDirector() + ", Year of Release : " + currentMovie.getYearOfRelease() + ", Rating : " + currentMovie.getRating());
                return;
            }
            currentMovie = currentMovie.next;
        }
    }

    //To display movie records in forward order
    public void displayRecordsForward(){
        if(head == null){
            System.out.print("\nRecords list is empty! No records to display!");
            return;
        }
        MovieNode currentMovie = head;
        System.out.print("\n------Displaying movie records(forward)-------");
        while(currentMovie != null){
            System.out.print("\nTitle: " + currentMovie.getTitle() + ", Director:  " + currentMovie.getDirector() + ", Year Of Release: " + currentMovie.getYearOfRelease() + ", Rating: " + currentMovie.getRating());
            currentMovie = currentMovie.next;
        }
    }

    //To display movie records in reverse order
    public void displayRecordsReverse(){
        if(head == null){
            System.out.print("\nThe movie record list is empty! No records to show. ");
            return;
        }
        //Traverse all the way to the end node
        MovieNode currentMovieNode = head;
        while(currentMovieNode.next != null){
            currentMovieNode = currentMovieNode.next;
        }
        System.out.print("\n------Displaying movie records(reverse)------");
        while(currentMovieNode != null){
            System.out.println("\nTitle: " + currentMovieNode.getTitle() + ", Director: " + currentMovieNode.getDirector() + ", Year Of Release: " + currentMovieNode.getYearOfRelease() + ", Rating: " + currentMovieNode.getRating());
            currentMovieNode = currentMovieNode.prev;
        }
    }

    //To update movie rating based on the movie title
    public void updateMovieRating(String title, String newRating){
        if(head == null){
            System.out.print("\nRecord list is empty! Add some records first.");
            return;
        }
        MovieNode currentMovieNode = head;
        while(currentMovieNode != null){
            if(currentMovieNode.getTitle().equals(title)){
                currentMovieNode.setRating(newRating);
                System.out.print("\nRating update successfull! New Rating: " + currentMovieNode.getRating());
                return;
            }
            currentMovieNode = currentMovieNode.next;
        }
        System.out.print("\nNo movie with such title found in record!");
    }

    public static void main(String[] args){
        MovieManagement management = new MovieManagement();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("\n------Movie Management System-------");
            System.out.print("\n1. Add Movie record at beginning.");
            System.out.print("\n2. Add Movie record at the end.");
            System.out.print("\n3. Add Movie record at the specific position.");
            System.out.print("\n4. Delete Movie record by their title.");
            System.out.print("\n5. Search for a movie record by their director or rating. ");
            System.out.print("\n6. Display all music records in forward order.");
            System.out.print("\n7. Display all music records in reverse order.");
            System.out.print("\n8. Update a movie's rating based on their title. ");
            System.out.print("\n9. Exit.");

            System.out.println();
            System.out.print("\nEnter a choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //consume next line

            switch(choice){
                case 1:
                    System.out.print("Enter Movie Title : ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter Movie Director : ");
                    String director1 = scanner.nextLine();
                    System.out.print("Ente Movie Year of release : ");
                    int year1 = scanner.nextInt();
                    System.out.print("Enter Movie Rating : ");
                    scanner.nextLine(); //Consume a line
                    String rating1 = scanner.nextLine();
                    management.addAtStart(title1, director1, year1, rating1);
                    break;

                case 2:
                    System.out.print("Enter Movie Title : ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter Movie Director : ");
                    String director2 = scanner.nextLine();
                    System.out.print("Ente Movie Year of release : ");
                    int year2 = scanner.nextInt();
                    System.out.print("Enter Movie Rating : ");
                    scanner.nextLine(); //Consume a line
                    String rating2 = scanner.nextLine();
                    management.addAtEnd(title2, director2, year2, rating2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter Movie Title : ");
                    scanner.nextLine(); //consume a line1
                    String title3 = scanner.nextLine();
                    System.out.print("Enter Movie Director : ");
                    String director3 = scanner.nextLine();
                    System.out.print("Ente Movie Year of release : ");
                    int year3 = scanner.nextInt();
                    System.out.print("Enter Movie Rating : ");
                    scanner.nextLine(); //Consume a line
                    String rating3 = scanner.nextLine();
                    management.addAtPosition(position, title3, director3, year3, rating3);
                    break;

                case 4:
                    System.out.print("Enter Movie title : ");
                    String title4 = scanner.nextLine();
                    management.deleteRecord(title4);
                    break;

                case 5:
                    System.out.print("Enter Movie director or rating: ");
                    String searchKey = scanner.nextLine();
                    management.searchRecord(searchKey);
                    break;

                case 6:
                    management.displayRecordsForward();
                    break;

                case 7:
                    management.displayRecordsReverse();
                    break;

                case 8:
                    System.out.print("Enter Movie title : ");
                    String title5 = scanner.nextLine();
                    System.out.print("Enter new rating : ");
                    String newRating = scanner.nextLine();
                    management.updateMovieRating(title5, newRating);
                    break;

                case 9:
                    System.out.println("Exiting.......");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again!");
            }
        }
    }
}
