package CircularLinkedLists.TaskScheduler;

import java.util.Scanner;

public class TaskScheduler {

    private TaskNode head;
    private TaskNode current;

    public void addAtStart(String taskID, String taskName, int taskPriority, String dueDate){
        TaskNode newTask = new TaskNode(taskID, taskName, taskPriority, dueDate);
        if(head == null){
            newTask.next = newTask; //circular reference
            head = newTask;
            current = head;
        } else {
            TaskNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
        System.out.print("\nTask added at the beginning of the scheduler.");
    }

    public void addAtEnd(String taskID, String taskName, int taskPriority, String dueDate){
        TaskNode newTask = new TaskNode(taskID, taskName, taskPriority, dueDate);
        if(head == null){
            newTask.next = newTask;
            head = newTask;
            current = newTask;
        } else {
            TaskNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
        System.out.print("\nTask added at the end of the scheduler.");
    }

    public void addAtSpecificPosition(int position, String taskID, String taskName, int taskPriority, String dueDate){
        if(position < 1){
            System.out.print("\nPosition must be >= 1.");
            return;
        }
        TaskNode newTask = new TaskNode(taskID, taskName, taskPriority, dueDate);
        if(position == 1){
            if(head == null){
                newTask.next = newTask;
                head = newTask;
                current = head;
                System.out.print("\nTask added to the scheduler at position " + position);
                return;
            } else {
                TaskNode temp = head;
                while(temp.next != head){
                    temp = temp.next;
                }
                temp.next = newTask;
                newTask.next = head;
                head = newTask;
            }
            System.out.print("\nTask added to the scheduler at position " + position);
            return;
        }

        //If adding at position other than 1
        TaskNode temp = head;
        //Traverse to the node just before the desired position of insertion
        for(int i = 1;i < position - 1;i++){
            temp = temp.next;
            //if we reach the head again the position is out of range
            if(temp == head){
                System.out.print("\nSpecified Position is out of bounds!");
                return;
            }
        }
        newTask.next = temp.next;
        temp.next = newTask;
        System.out.print("\nTask added to the scheduler at position " + position);
        return;
    }

    public void deleteTask(String taskID){
        if(head == null){
            System.out.print("\nTask list is empty. No tasks to remove!");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;
        if(head.getTaskID().equals(taskID)){
            while(temp.next != head){
                temp = temp.next;
            }
            if(head.next == head){
                head = null;
                System.out.print("\nTask removed from the list!");
                return;
            } else {
                temp.next = head.next;
                head = head.next;
            }
            System.out.print("\nTask removed from the list successfully!");
            return;
        }
        temp = head;
        while(true){
            prev = temp;
            temp = temp.next;

            if(temp.getTaskID().equals(taskID)) {
                prev.next = temp.next;
                System.out.print("\nTask removed from the list successfully!");
                return;
            }
            if(temp == head) break;
        }
        System.out.print("\nNo task with id " + taskID + " found in the list!");
    }

    public void viewCurrentTaskAndMove(){
        if(head == null){
            System.out.print("\nNo tasks in the scheduler to show!");
            return;
        }
        System.out.print("\nCurrent task id: " + current.getTaskID() + ", name: " + current.getTaskName() + ", priority: " + current.getTaskPriority() + ", due date: " + current.getDueDate());
        current = current.next;
        System.out.print("\nNext task : " + current.getTaskName());
        return;
    }

    public void displayTasks(){
        if(head == null){
            System.out.print("\nNo tasks in the scheduler list!");
            return;
        }
        TaskNode temp = head;
        System.out.print("\n------Displaying All tasks------");
        while(true){
            System.out.print("\nTask ID : " + temp.getTaskID() + ", Task Name : " + temp.getTaskName() + ", Task Priority : " + temp.getTaskPriority() + ", Task Due Date : " + temp.getDueDate());
            temp = temp.next;
            if(temp == head) break;
        }
    }

    public void searchTask(int priority){
        if(head == null){
            System.out.print("\nNo task in task scheduler. Add some tasks first!");
            return;
        }
        TaskNode temp = head;
        while(true){
            if(temp.getTaskPriority() == priority){
                System.out.print("\nMatch found! Showing task details below: ");
                System.out.print("\nTask ID: " + temp.getTaskID() + ", Task Name: " + temp.getTaskName() + ", Task Priority: " + temp.getTaskPriority() + ", Task Due Date: " + temp.getDueDate());
                return;
            }
            temp = temp.next;
            if(temp == head) break;
        }
        System.out.print("\nNo task with priority " + priority + " found in the tasks list!");
    }

    public static void main(String[] args){
        TaskScheduler taskScheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("\n------Task Scheduler-------");
            System.out.print("\n1. Add Task at beginning.");
            System.out.print("\n2. Add Task at the end.");
            System.out.print("\n3. Add Task at the specific position.");
            System.out.print("\n4. Delete Task by their ID.");
            System.out.print("\n5. View current task and move to next task.");
            System.out.print("\n6. Display all tasks in the scheduler.");
            System.out.print("\n7. Search for a task by their Priority");
            System.out.print("\n8. Exit.");

            System.out.println();
            System.out.print("\nEnter a choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //consume next line

            switch(choice){
                case 1:
                    System.out.print("Enter Task ID : ");
                    String id1 = scanner.nextLine();
                    System.out.print("Enter Task Name : ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter Task Priority : ");
                    int priority1 = scanner.nextInt();
                    System.out.print("Enter Task Due Date : ");
                    scanner.nextLine(); //Consume a line
                    String date1 = scanner.nextLine();
                    taskScheduler.addAtStart(id1, name1, priority1, date1);
                    break;

                case 2:
                    System.out.print("Enter Task ID : ");
                    String id2 = scanner.nextLine();
                    System.out.print("Enter Task Name : ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Task Priority : ");
                    int priority2 = scanner.nextInt();
                    System.out.print("Enter Task Due Date : ");
                    scanner.nextLine(); //Consume a line
                    String date2 = scanner.nextLine();
                    taskScheduler.addAtEnd(id2, name2, priority2, date2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter Task ID : ");
                    scanner.nextLine();
                    String id3 = scanner.nextLine();
                    System.out.print("Enter Task Name : ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter Task Priority : ");
                    int priority3 = scanner.nextInt();
                    System.out.print("Enter Task Due Date : ");
                    scanner.nextLine(); //Consume a line
                    String date3 = scanner.nextLine();
                    taskScheduler.addAtSpecificPosition(position, id3, name3, priority3, date3);
                    break;

                case 4:
                    System.out.print("Enter Task ID to be deleted : ");
                    String id4 = scanner.nextLine();
                    taskScheduler.deleteTask(id4);
                    break;

                case 5:
                    taskScheduler.viewCurrentTaskAndMove();
                    break;

                case 6:
                    taskScheduler.displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Task Priority : ");
                    int priority4 = scanner.nextInt();
                    taskScheduler.searchTask(priority4);
                    break;

                case 8:
                    System.out.println("Exiting.......");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again!");
            }
        }
    }
}
