package CircularLinkedLists.RoundRobin;

import java.util.Scanner;

public class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int processCount;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.processCount = 0;
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end (Circular Linked List insertion)
    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);

        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        processCount++;
        System.out.println("\nProcess " + processID + " added successfully.");
    }

    // Remove a process after execution
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("\nNo processes to remove.");
            return;
        }

        ProcessNode current = head, prev = null;

        // Finding the process to remove
        do {
            if (current.getProcessID() == processID) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else {
                    if (current == head) {
                        head = head.next;
                        tail.next = head;
                    } else if (current == tail) {
                        prev.next = head;
                        tail = prev;
                    } else {
                        prev.next = current.next;
                    }
                }
                processCount--;
                System.out.println("\nProcess " + processID + " removed after execution.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate Round Robin Scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("\nNo processes to schedule.");
            return;
        }

        int currentTime = 0;
        ProcessNode current = head;

        System.out.println("\nStarting Round Robin Scheduling...");
        while (processCount > 0) {
            if (current.getBurstTime() > 0) {
                int executionTime = Math.min(timeQuantum, current.getBurstTime());
                currentTime += executionTime;
                current.setBurstTime(current.getBurstTime() - executionTime);

                System.out.println("Executing Process " + current.getProcessID() + " for " + executionTime + " units.");
                displayProcesses();

                if (current.getBurstTime() == 0) {
                    current.setTurnAroundTime(currentTime);
                    current.setWaitingTime(current.getTurnAroundTime() - executionTime);
                    removeProcess(current.getProcessID());
                }
            }
            current = current.next;
        }
        displayAverageTimes();
    }

    // Display the processes in circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("\nNo processes in the queue.");
            return;
        }

        System.out.println("\nProcesses in queue:");
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.getProcessID() + ", Burst Time: " + temp.getBurstTime());
            temp = temp.next;
        } while (temp != head);
    }

    // Calculate and display average waiting time and turnaround time
    public void displayAverageTimes() {
        int totalWaitingTime = 0, totalTurnAroundTime = 0, totalProcesses = processCount;

        ProcessNode temp = head;
        do {
            totalWaitingTime += temp.getWaitingTime();
            totalTurnAroundTime += temp.getTurnAroundTime();
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / totalProcesses);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter time quantum: ");
        int quantum = scanner.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(quantum);

        while (true) {
            System.out.println("\n------- Round Robin CPU Scheduling -------");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Display Processes");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int pid = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = scanner.nextInt();
                    scheduler.addProcess(pid, burstTime, priority);
                    break;

                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    int removeID = scanner.nextInt();
                    scheduler.removeProcess(removeID);
                    break;

                case 3:
                    scheduler.simulateScheduling();
                    break;

                case 4:
                    scheduler.displayProcesses();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
