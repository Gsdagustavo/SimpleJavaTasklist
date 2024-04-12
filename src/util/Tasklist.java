package util;

public class Tasklist {

    private String task;
    private String taskPriority;
    private int taskIndex;


    // Constructors
    public Tasklist() {
    }

    public Tasklist(String task, int taskIndex) {
        this.task = task;
        this.taskIndex = taskIndex;
    }

    // Getters and Setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public void setTaskIndex(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String toString() {
        return this.taskIndex + "#: " + this.task;
    }
}
