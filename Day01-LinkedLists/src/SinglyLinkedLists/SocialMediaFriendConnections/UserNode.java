package SinglyLinkedLists.SocialMediaFriendConnections;

import java.util.ArrayList;
import java.util.List;

public class UserNode {
    private int userID;
    private String name;
    private int age;
    private List<Integer> friendIDs; // List of Friend IDs
    UserNode next;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getFriendIDs() {
        return friendIDs;
    }

    public void addFriend(int friendID) {
        if (!friendIDs.contains(friendID)) {
            friendIDs.add(friendID);
        }
    }

    public void removeFriend(int friendID) {
        friendIDs.remove(Integer.valueOf(friendID));
    }
}
