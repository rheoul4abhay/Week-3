package SinglyLinkedLists.StudentRecordManagement;

import java.util.Scanner;

public class StudentRecordManagement {

    private StudentNode head;

    //To add new student record at the start of a linkedlist
    public void addAtStart(String rollNumber, String name, int age, String grade){
        StudentNode newStudentNode = new StudentNode(rollNumber, name, age, grade);
        newStudentNode.nextStudent = head;
        head = newStudentNode;
        System.out.print("\nStudent " + newStudentNode.getName() + " added at start successfully!");
    }

    //To add new Student record at the end of a linkedlist
    public void addAtEnd(String rollNumber, String name, int age, String grade){
        StudentNode newStudentNode = new StudentNode(rollNumber, name, age, grade);
        if(head == null){
            head = newStudentNode;
            System.out.print("\nStudent " + newStudentNode.getName() + " added at the end successfully!");
            return;
        }

        //Traverse all the way till the last node
        StudentNode currentStudent = head;
        while(currentStudent.nextStudent != null){
            currentStudent = currentStudent.nextStudent;
        }
        currentStudent.nextStudent = newStudentNode;
        System.out.print("\nStudent " + newStudentNode.getName() + " added at the end successfully!");
    }

    //To add new student at any specific position in the list
    public void addAtPosition(int position, String rollNumber, String name, int age, String grade){
        if(position < 1){
            System.out.print("\nPosition should be >= 1!");
            return;
        }

        StudentNode newStudentNode = new StudentNode(rollNumber, name, age, grade);
        if(position == 1){
            newStudentNode.nextStudent = head;
            head = newStudentNode;
            System.out.print("\nStudent " + newStudentNode.getName() + " added at position " + position + " successfully!");
            System.out.println();
            return;
        }

        //To add at specific place we traverse all the way to the node before the position where node is to be inserted
        int count = 1;
        StudentNode currentStudent = head;
        while(currentStudent != null && count < position - 1){
            currentStudent = currentStudent.nextStudent;
            count++;
        }

        if(currentStudent == null){
            System.out.print("\nSpecified position is out of bounds!");
            System.out.println();
            return;
        } else {
            newStudentNode.nextStudent = currentStudent.nextStudent;
            currentStudent.nextStudent = newStudentNode;
            System.out.print("\nStudent added at position " + position + " successfully!");
            System.out.println();
            return;
        }
    }

    //To delete a student record by their roll number
    public void deleteRecord(String rollNumber){
        if(head == null){
            System.out.print("\nList is empty! Add some student records first!");
            System.out.println();
            return;
        }

        StudentNode currentStudentNode = head;
        if(head.getRollNumber().equals(rollNumber)){
            head = head.nextStudent;
            System.out.print("\nStudent with roll number " + rollNumber + " deleted from records successfully!");
            System.out.println();
            return;
        }

        //We aim to traverse to reach the node right before the node to be deleted(if it is found)
        while(currentStudentNode.nextStudent != null && !(currentStudentNode.nextStudent.getRollNumber().equals(rollNumber))){
            currentStudentNode = currentStudentNode.nextStudent;
        }

        if(currentStudentNode.nextStudent == null){
            System.out.print("\nNo student record found with roll number " + rollNumber);
            System.out.println();
            return;
        }
        else {
            currentStudentNode.nextStudent = currentStudentNode.nextStudent.nextStudent;
            System.out.print("\nStudent with roll number " + rollNumber + " deleted from records successfully!");
            System.out.println();
            return;
        }
    }

    //Search a student record by their roll number
    public void searchRecord(String rollNumber){
        if(head == null){
            System.out.print("\nStudent record list is empty!");
            System.out.println();
            return;
        }

        StudentNode currentStudentNode = head;
        boolean nodeFound = false;
        while(currentStudentNode != null){
            if(currentStudentNode.getRollNumber().equals(rollNumber)){
                System.out.print("\nRecord found. Roll Number : " + rollNumber + ", Name : " + currentStudentNode.getName() + ", Age : " + currentStudentNode.getAge() + ", Grade : " + currentStudentNode.getGrade());
                nodeFound = true;
            }
            currentStudentNode = currentStudentNode.nextStudent;
        }
        if(!nodeFound){
            System.out.print("\nNo student record found for roll number : " + rollNumber);
            System.out.println();
            return;
        }
    }

    //Display all student records
    public void displayRecords(){
        if(head == null){
            System.out.print("\nRecord list is empty. No record to display!");
            System.out.println();
            return;
        }

        StudentNode currentStudentNode = head;
        System.out.print("-------\nShowing all student records------");
        while(currentStudentNode != null){
            System.out.print("\nStudent roll number: " + currentStudentNode.getRollNumber() + ", name: " + currentStudentNode.getName() + ", age : " + currentStudentNode.getAge() + ", grade : " + currentStudentNode.getGrade());
            currentStudentNode = currentStudentNode.nextStudent;
        }
    }

    //Update student grade based on their
    public void updateStudentGrade(String rollNumber, String newGrade){
        if(head == null){
            System.out.print("\nRecord list is empty. Enter some records first!");
            System.out.println();
            return;
        }

        StudentNode currentStudentNode = head;
        boolean nodeFound = false;
        while(currentStudentNode != null){
            if(currentStudentNode.getRollNumber().equals(rollNumber)){
                currentStudentNode.setGrade(newGrade);
                System.out.print("\nStudent grade updated in record for student with roll number " + rollNumber + " successfully!" + " New grade : " + currentStudentNode.getGrade());
                nodeFound = true;
            }
            currentStudentNode = currentStudentNode.nextStudent;
        }

        if(!nodeFound){
            System.out.print("\nNo student record with roll number " + rollNumber + " found!");
            System.out.println();
            return;
        }
    }

    public static void main(String[] args){
        StudentRecordManagement management = new StudentRecordManagement();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("\n-------Student Records Management System-------");
            System.out.print("\n1. Add Student record at beginning.");
            System.out.print("\n2. Add Student record at the end.");
            System.out.print("\n3. Add Student record at the specific position.");
            System.out.print("\n4. Delete Student record by their roll number.");
            System.out.print("\n5. Search for a student record by their roll number. ");
            System.out.print("\n6. Display all students records.");
            System.out.print("\n7. Update a student's grade based on their roll number. ");
            System.out.print("\n8. Exit.");

            System.out.println();
            System.out.print("\nEnter a choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //consume next line

            switch(choice){
                case 1:
                    System.out.print("Enter Roll number : ");
                    String rollNumber1 = scanner.nextLine();
                    System.out.print("Enter Name : ");
                    String name1 = scanner.nextLine();
                    System.out.print("Ente Age : ");
                    int age1 = scanner.nextInt();
                    System.out.print("Enter grade : ");
                    scanner.nextLine(); //Consume a line
                    String grade1 = scanner.nextLine();
                    management.addAtStart(rollNumber1, name1, age1, grade1);
                    break;

                case 2:
                    System.out.print("Enter Roll number : ");
                    String rollNumber2 = scanner.nextLine();
                    System.out.print("Enter Name : ");
                    String name2 = scanner.nextLine();
                    System.out.print("Ente Age : ");
                    int age2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade : ");
                    String grade2 = scanner.nextLine();
                    management.addAtEnd(rollNumber2, name2, age2, grade2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter Roll number : ");
                    scanner.nextLine();
                    String rollNumber3 = scanner.nextLine();
                    System.out.print("Enter Name : ");
                    String name3 = scanner.nextLine();
                    System.out.print("Ente Age : ");
                    int age3 = scanner.nextInt();
                    System.out.print("Enter grade : ");
                    scanner.nextLine();
                    String grade3 = scanner.nextLine();
                    management.addAtPosition(position, rollNumber3, name3, age3, grade3);
                    break;

                case 4:
                    System.out.print("Enter student roll number: ");
                    String rollNumber4 = scanner.nextLine();
                    management.deleteRecord(rollNumber4);
                    break;

                case 5:
                    System.out.print("Enter student roll number: ");
                    String rollNumber5 = scanner.nextLine();
                    management.searchRecord(rollNumber5);
                    break;

                case 6:
                    management.displayRecords();
                    break;

                case 7:
                    System.out.print("Enter student roll number : ");
                    String rollNumber6 = scanner.nextLine();
                    System.out.print("Enter new grade : ");
                    String newGrade = scanner.nextLine();
                    management.updateStudentGrade(rollNumber6, newGrade);
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

