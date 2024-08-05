package Task2;

public class Task {
    private String taskId;
    private String description;
    private boolean completed;

    public Task(String taskId, String description, boolean completed) {
        this.taskId = taskId;
        this.description = description;
        this.completed = completed;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
