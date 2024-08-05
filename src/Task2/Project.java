package Task2;

import java.util.List;

public class Project {
    private String projectId;
    private String projectName;
    private List<Task> tasks;

    public Project(String projectId, String projectName, List<Task> tasks) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
