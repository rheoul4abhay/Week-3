package SinglyLinkedLists.SocialMediaFriendConnections;

import java.util.*;

public class FriendConnections {
    private UserNode head;

    public FriendConnections() {
        this.head = null;
    }

    // Add a new user to the system
    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("\nUser " + name + " added successfully.");
    }

    // Search for a user by User ID
    private UserNode getUserByID(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.getUserID() == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search for a user by Name
    private UserNode getUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.getName().equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        UserNode user1 = getUserByID(userID1);
        UserNode user2 = getUserByID(userID2);

        if (user1 != null && user2 != null && user1 != user2) {
            user1.addFriend(userID2);
            user2.addFriend(userID1);
            System.out.println("\nFriend connection added between " + user1.getName() + " and " + user2.getName());
        } else {
            System.out.println("\nError: Users not found or cannot be the same.");
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        UserNode user1 = getUserByID(userID1);
        UserNode user2 = getUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userID2);
            user2.removeFriend(userID1);
            System.out.println("\nFriend connection removed between " + user1.getName() + " and " + user2.getName());
        } else {
            System.out.println("\nError: Users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = getUserByID(userID1);
        UserNode user2 = getUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("\nError: Users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.getFriendIDs());
        mutualFriends.retainAll(user2.getFriendIDs());

        System.out.println("\nMutual Friends between " + user1.getName() + " and " + user2.getName() + ":");
        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            for (int id : mutualFriends) {
                UserNode friend = getUserByID(id);
                System.out.println(friend.getName() + " (User ID: " + friend.getUserID() + ")");
            }
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        UserNode user = getUserByID(userID);

        if (user == null) {
            System.out.println("\nError: User not found.");
            return;
        }

        System.out.println("\nFriends of " + user.getName() + ":");
        if (user.getFriendIDs().isEmpty()) {
            System.out.println("No friends yet.");
        } else {
            for (int id : user.getFriendIDs()) {
                UserNode friend = getUserByID(id);
                System.out.println(friend.getName() + " (User ID: " + friend.getUserID() + ")");
            }
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        System.out.println("\nFriend Count for Each User:");
        while (temp != null) {
            System.out.println(temp.getName() + " has " + temp.getFriendIDs().size() + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FriendConnections network = new FriendConnections();

        while (true) {
            System.out.println("\n------- Social Media Friend Connections -------");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends of a User");
            System.out.println("6. Count Friends of Each User");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 7) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    network.addUser(userID, name, age);
                    break;

                case 2:
                    System.out.print("Enter User ID 1: ");
                    int userID1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userID2 = scanner.nextInt();
                    network.addFriendConnection(userID1, userID2);
                    break;

                case 3:
                    System.out.print("Enter User ID 1: ");
                    int removeID1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int removeID2 = scanner.nextInt();
                    network.removeFriendConnection(removeID1, removeID2);
                    break;

                case 4:
                    System.out.print("Enter User ID 1: ");
                    int mutualID1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int mutualID2 = scanner.nextInt();
                    network.findMutualFriends(mutualID1, mutualID2);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int displayID = scanner.nextInt();
                    network.displayFriends(displayID);
                    break;

                case 6:
                    network.countFriends();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
