package Task2;

import java.util.*;
import java.util.stream.Collectors;

public class ans4 {
    public static void main(String[] args) {

        Task task1 = new Task("1","Design", true);
        Task task2 = new Task("2","Development", false);
        Task task3 = new Task("3","Testing", true);
        Task task4 = new Task("4","Deployment", false);
        Task task5 = new Task("5","Dog", true);

        Project project1 = new Project("1","Project1", Arrays.asList(task1, task2));
        Project project2 = new Project("2","Project2", Arrays.asList(task3, task4));
        Project project3 = new Project("3","Project3", Arrays.asList(task1, task4, task5));


        List<Project> projectList = new ArrayList<>();
        projectList.add(project1);
        projectList.add(project2);
        projectList.add(project3);

        Map<String, Integer> completedTasksMap = isCompletedTasks(projectList);
        System.out.println("Completed Tasks per Project: " + completedTasksMap);

        String highestCompletedTaskProject = projectWithHighestCompletedTask(projectList);
        System.out.println("Project with Highest Completed Tasks: " + highestCompletedTaskProject);

        List<Task> incompleteTasks = projectWithTaskIsNotCompleted(projectList);
        System.out.println("Incomplete Tasks: " + incompleteTasks);

        List<Task> tasksWithDescription = withSame(projectList, "Development", false);
        System.out.println("Tasks with description containing 'Development' and not completed: " + tasksWithDescription);
    }

    public static Map<String,Integer> isCompletedTasks(List<Project> projectList){
        return projectList.stream()
                .collect(Collectors.toMap(
                        Project::getProjectId,
                        project -> (int)project.getTasks().
                                stream().
                                filter(Task::isCompleted).count()
                ));
    }

    public static String projectWithHighestCompletedTask(List<Project> projectList){
        Map<String,Integer> completedTask = isCompletedTasks(projectList);
        return completedTask.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static List<Task> projectWithTaskIsNotCompleted (List<Project> projectList){
        return projectList.stream()
                .flatMap(project -> project.getTasks().stream())
                        .filter(task -> !task.isCompleted())
                        .collect(Collectors.toList());
//        List<Task> incompleteTasks = new LinkedList<>();
//        for (Project project : projectList) {
//            for (Task task : project.getTasks()) {
//                if (!task.isCompleted()) {
//                    incompleteTasks.add(task);
//                }
//            }
//        }
//        return incompleteTasks;
    }

    public static List<Task> withSame (List<Project> projectList,String description,boolean completed){
        return projectList.stream()
                .flatMap(project -> project.getTasks()
                        .stream())
                .filter(task -> task.isCompleted() == completed && task.getDescription().contains(description))
                .collect(Collectors.toList());

//        List<Task> withSame = new LinkedList<>();
//        for (Project project : projectList){
//            for (Task task : project.getTasks()){
//                if (task.getDescription().contains(description) && task.isCompleted() == completed){
//                    withSame.add(task);
//                }
//            }
//        }
//        return withSame;
    }

}
