package DoublyLinkedLists.UndoRedoFunction;

import java.util.Scanner;

public class UndoRedoTextEditor {
    private TextStateNode head, tail, current;
    private final int MAX_HISTORY = 10; // Limit history to last 10 states
    private int size = 0;

    public UndoRedoTextEditor() {
        head = tail = current = null;
    }

    // Add new text state (Typing or performing an action)
    public void addTextState(String newText) {
        TextStateNode newState = new TextStateNode(newText);

        // If list is empty, set it as the first node
        if (head == null) {
            head = tail = current = newState;
        } else {
            // Remove redo history if any
            while (current.next != null) {
                current.next = null;
            }

            // Add new state at the end
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;

            // Ensure history does not exceed limit
            if (size == MAX_HISTORY) {
                head = head.next;
                head.prev = null;
            } else {
                size++;
            }
        }
        System.out.println("Current Text: \"" + current.textState + "\"");
    }

    // Undo: Revert to previous state
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("No undo available.");
            return;
        }
        current = current.prev;
        System.out.println("Undo: \"" + current.textState + "\"");
    }

    // Redo: Move forward to the next state
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("No redo available.");
            return;
        }
        current = current.next;
        System.out.println("Redo: \"" + current.textState + "\"");
    }

    // Display the current text state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current Text: \"" + current.textState + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndoRedoTextEditor editor = new UndoRedoTextEditor();

        while (true) {
            System.out.println("\n----- Undo/Redo Text Editor -----");
            System.out.println("1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = scanner.nextLine();
                    editor.addTextState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
