package To_Do_List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private final List<Task> tasks;
    private int nextId = 1;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Scanner scanner) {
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter due date (YYYY-MM-DD):");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter priority:");
        String priority = scanner.nextLine();
        Task newTask = new Task(nextId++, description, dueDate, priority);
        tasks.add(newTask);
        System.out.println("Task added successfully.");
    }

    public void deleteTask(Scanner scanner) {
        System.out.println("Enter task ID to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted if it existed.");
    }

    public void updateTask(Scanner scanner) {
        System.out.println("Enter task ID to update:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println("Enter new description (current: " + task.getDescription() + "):");
                task.setDescription(scanner.nextLine());
                System.out.println("Enter new due date (current: " + task.getDueDate() + "):");
                task.setDueDate(LocalDate.parse(scanner.nextLine()));
                System.out.println("Enter new priority (current: " + task.getPriority() + "):");
                task.setPriority(scanner.nextLine());
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
