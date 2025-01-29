package CircularLinkedLists.OnlineTicketReservation;

import java.util.Scanner;

public class TicketReservationSystem {
    private TicketNode last;
    private int totalTickets = 0;

    public TicketReservationSystem() {
        this.last = null;
    }

    // Add new ticket at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber);

        if (last == null) {
            // If list is empty, point the new ticket to itself
            last = newTicket;
            last.next = last;
        } else {
            // Insert new ticket at the end
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }

        totalTickets++;
        System.out.println("Ticket booked successfully!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = last.next, prev = last;
        boolean found = false;

        // Check if it's the only node
        if (last == last.next && last.ticketID == ticketID) {
            last = null;
            found = true;
        } else {
            do {
                if (current.ticketID == ticketID) {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev; // If last node is removed, update last
                    }
                    found = true;
                    break;
                }
                prev = current;
                current = current.next;
            } while (current != last.next);
        }

        if (found) {
            totalTickets--;
            System.out.println("Ticket " + ticketID + " removed successfully.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    // Display all booked tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = last.next;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID: " + current.ticketID +
                    ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName +
                    ", Seat: " + current.seatNumber +
                    ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets found.");
            return;
        }

        TicketNode current = last.next;
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + current.ticketID +
                        ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName +
                        ", Seat: " + current.seatNumber +
                        ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for: " + query);
        }
    }

    // Get total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Online Ticket Reservation ---");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 6) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();

                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();

                    system.addTicket(ticketID, customerName, movieName, seatNumber);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to Cancel: ");
                    int removeID = scanner.nextInt();
                    system.removeTicket(removeID);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name or Movie Name to Search: ");
                    String query = scanner.nextLine();
                    system.searchTicket(query);
                    break;

                case 5:
                    System.out.println("Total Tickets Booked: " + system.getTotalTickets());
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
