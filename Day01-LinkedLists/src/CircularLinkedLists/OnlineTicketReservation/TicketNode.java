package CircularLinkedLists.OnlineTicketReservation;

import java.time.LocalDateTime;

public class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}
