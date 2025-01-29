package SinglyLinkedLists.InventoryManagement;

public class InventoryNode {
    private String itemName;
    private String itemID;
    private int itemQuantity;
    private double itemPrice;
    InventoryNode next;

    public InventoryNode(String itemName, String itemID, int itemQuantity, double itemPrice){
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.next = null;
    }

    //getters
    public String getItemName(){
        return itemName;
    }

    public String getItemID(){
        return itemID;
    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    //setter
    public void setItemName(String newName){
        itemName = newName;
    }

    public void setItemQuantity(int newQuantity){
        itemQuantity = newQuantity;
    }

    public void setItemID(String newID){
        itemID = newID;
    }

    public void setItemPrice(double newPrice){
        itemPrice = newPrice;
    }
}
