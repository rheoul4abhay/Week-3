package CircularLinkedLists.TaskScheduler;

public class TaskNode {
    private String taskID;
    private String taskName;
    private int taskPriority;
    private String dueDate;
    TaskNode next, prev;

    public TaskNode(String taskID, String taskName, int taskPriority, String dueDate){
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.dueDate = dueDate;
        this.next = this;
    }

    //getters
    public String getTaskID(){
        return taskID;
    }

    public String getTaskName(){
        return taskName;
    }

    public int getTaskPriority(){
        return taskPriority;
    }

    public String getDueDate(){
        return dueDate;
    }
}
