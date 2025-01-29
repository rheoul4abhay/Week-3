package SinglyLinkedLists.InventoryManagement;

import java.util.Scanner;

public class InventoryManagementSystem {

    private InventoryNode head;

    public void addAtStart(String itemName, String itemID, int itemQuantity, double itemPrice){
        InventoryNode newItem = new InventoryNode(itemName, itemID, itemQuantity, itemPrice);
        if(head == null){
            head = newItem;
            System.out.print("\nItem with name " + itemName + " added at the start of the list!");
            return;
        }
        newItem.next = head;
        head = newItem;
        System.out.print("\nItem with name " + itemName + " added at the start of the list!");
        return;
    }

    public void addAtEnd(String itemName, String itemID, int itemQuantity, double itemPrice){
        InventoryNode newItem = new InventoryNode(itemName, itemID, itemQuantity, itemPrice);
        if(head == null){
            head = newItem;
            System.out.print("\nItem with name " + itemName + " added to the end of the list!");
            return;
        }
        InventoryNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newItem;
        System.out.print("\nItem with name " + itemName + " added to the end of the list!");
        return;
    }

    public void addAtSpecificPosition(int position, String itemName, String itemID, int itemQuantity, double itemPrice){
        InventoryNode newItem = new InventoryNode(itemName, itemID, itemQuantity, itemPrice);
        if(position < 1){
            System.out.print("\nPosition must be >= 1.");
            return;
        }

        if(position == 1){
            newItem.next = head;
            head = newItem;
            System.out.print("\nItem added at position " + position);
            return;
        }

        InventoryNode temp = head;
        for(int i = 1;i < position -1;i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.print("\nPosition out of bounds!");
            return;
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
            System.out.print("\nItem added at position " + position);
            return;
        }
    }

    public void deleteItem(String itemID){
        if(head == null){
            System.out.print("\nList is empty! Add some items first!");
            return;
        }

        if(head.getItemID().equals(itemID)){
            head = head.next;
            System.out.print("\nItem with ID " + itemID + " removed from list successfully!");
            return;
        }

        InventoryNode temp = head;
        InventoryNode prev = null;
        while(temp != null){
            if(temp.getItemID().equals(itemID)){
                prev.next = temp.next;
                System.out.print("\nItem with ID : "  + itemID + " deleted successfully!");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.print("\nItem with ID " + itemID + " not found in the list!");
        return;
    }

    public void updateQuantity(String itemID, int newQuantity){
        
        if(head == null){
            System.out.println("\nList is empty! Add some items first.");
            return;
        }
        
        InventoryNode temp = head;
        while(temp != null){
            if(temp.getItemID().equals(itemID)){
                temp.setItemQuantity(newQuantity);
                System.out.print("\nQuantity updated for item with ID : " + temp.getItemID() + ". New Quantity: " + temp.getItemQuantity());
                return;
            }
            temp = temp.next;
        }
        System.out.print("\nItem with specified ID not found in the list!");
        return;
    }

    public void searchItem(String searchKey){
        
        if(head == null){
            System.out.print("\nList is empty! Add some items first!");
            return;
        }
        
        InventoryNode temp = head;
        while(temp != null){
            if(temp.getItemID().equals(searchKey) || temp.getItemName().equals(searchKey)){
                System.out.print("\nMatch Found!");
                System.out.print("\nItem ID: " + temp.getItemID() + ", Name: " + temp.getItemName() + ", Item Quantity: " + temp.getItemQuantity() + ", Item price: " + temp.getItemPrice());
                return;
            }
            temp = temp.next;
        }
        System.out.println("\nNo matching item found with given search key!");
        return;
    }

    public void displayTotalItemValue(){
        if(head == null){
            System.out.print("\nList is empty. Add some items first!");
            return;
        }
        InventoryNode temp = head;
        while(temp != null){
            System.out.print("\nItem name " + temp.getItemName() + "'s total price is $" + (temp.getItemPrice() * temp.getItemQuantity()));
            temp = temp.next;
        }
    }

    public void swap(InventoryNode item1, InventoryNode item2){
        String tempID = item1.getItemID();
        String tempName = item1.getItemName();
        double tempPrice = item1.getItemPrice();
        int tempQuantity = item1.getItemQuantity();
        
        item1.setItemID(item2.getItemID());
        item1.setItemName(item2.getItemName());
        item1.setItemPrice(item2.getItemPrice());
        item1.setItemQuantity(item2.getItemQuantity());

        item2.setItemID(tempID);
        item2.setItemName(tempName);
        item2.setItemPrice(tempPrice);
        item2.setItemQuantity(tempQuantity);
    }
    
    public void sortInventory(double itemPrice){
        while(head != null){
            InventoryNode nextItem = head.next;
            while(nextItem != null){
                if(head.getItemPrice() > nextItem.getItemPrice()){
                    swap(head, nextItem);
                }
                nextItem = nextItem.next;
            }
            head = head.next;
        }
    }
    
    public static void main(String[] args){
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------- Inventory Management System -------");
            System.out.println("1. Add Item at Start");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Specific Position");
            System.out.println("4. Delete Item by ID");
            System.out.println("5. Search for Item by ID or Name");
            System.out.println("6. Display Inventory Total item");
            System.out.println("7. Update Item Quantity");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item ID: ");
                    String id1 = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty1 = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price1 = scanner.nextDouble();
                    inventory.addAtStart(name1, id1, qty1, price1);
                    break;

                case 2:
                    System.out.print("Enter Item ID: ");
                    String id2 = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty2 = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price2 = scanner.nextDouble();
                    inventory.addAtEnd(name2, id2, qty2, price2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    String id3 = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty3 = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price3 = scanner.nextDouble();
                    inventory.addAtSpecificPosition(position, name3, id3, qty3, price3);
                    break;

                case 4:
                    System.out.print("Enter Item ID to Delete: ");
                    String id4 = scanner.nextLine();
                    inventory.deleteItem(id4);
                    break;

                case 5:
                    System.out.print("Enter Item ID or Name to Search: ");
                    String searchKey = scanner.nextLine();
                    inventory.searchItem(searchKey);
                    break;

                case 6:
                    inventory.displayTotalItemValue();
                    break;

                case 7:
                    System.out.print("Enter Item ID: ");
                    String id6 = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = scanner.nextInt();
                    inventory.updateQuantity(id6, newQty);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
