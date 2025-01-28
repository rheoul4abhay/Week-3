package SinglyLinkedLists.StudentRecordManagement;

public class StudentNode {
    private String rollNumber;
    private String name;
    private int age;
    private String grade;
    StudentNode nextStudent;

    public StudentNode(String rollNumber, String name, int age, String grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.nextStudent = null;
    }

    //getters
    public String getRollNumber(){
        return rollNumber;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGrade(){
        return grade;
    }

    //setter for grade
    public void setGrade(String newGrade){
        grade = newGrade;
    }
}
